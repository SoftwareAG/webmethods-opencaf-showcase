package caf.war.wm_opencaf_showcase;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import com.webmethods.caf.common.StringTools;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.convert.ConvertUtils;
import com.webmethods.caf.faces.data.tree.object.FilterableListTreeContentProvider;

@ManagedBean(name="allTopics")
@SessionScoped
public class AllTopics extends BaseFacesBean {
	List<Topic> topics = null;
    protected FilterableListTreeContentProvider m_xmlTree;
	private static AtomicInteger counter = new AtomicInteger(0);

    public FilterableListTreeContentProvider getTopicTree() {
        if (m_xmlTree == null) {
			try {
		        m_xmlTree = new FilterableListTreeContentProvider(getTopicList(), "topic", 
		        		"#{topic.id}", "#{topic.parentId}", 
		        		null, "#{topic.filterText}") {

					@Override
					public void setFilter(String filter) {
				        if ((ConvertUtils.isEmpty(m_filter) && ConvertUtils.isEmpty(filter)) || (m_filter != null && m_filter.equals(filter))) {
					        // new filter is same as old
					        super.setFilter(filter);
				        } else {
					        super.setFilter(filter);
			        		setOpenIds(Collections.emptyList());
				        	//new filter is different, so reset the openIds
				        	if (StringTools.notEmpty(filter)) {
					        	setOpenToDepth(5);
				        	}
				        }
					}
		        	
		        };
			} catch (Exception e) {
				error(e);
			}
        }
        return m_xmlTree;
    }
    
    
	public List<Topic> getTopicList() {
		if (topics == null) {
        	counter.set(0);
			List<Topic> tl = new ArrayList<Topic>();
			try {
		        // Create new factory.
		        SAXParserFactory factory = SAXParserFactory.newInstance();

		        // Specifies that the parser produced by this factory will
		        // not validate documents as they are parsed.
		        factory.setValidating(false);
		
		        // This parser will not validate XML-input:
		        SAXParser saxParser = factory.newSAXParser();

				//parse the xml to locate the topics.
		    	InputStream inStream = null;
		        try {
		            inStream = getClass().getResourceAsStream("topicList.xml");
		            TopicListXmlHandler handler = new TopicListXmlHandler(tl);
		            saxParser.parse(inStream, handler);
		        } finally {
		            if (inStream != null) {
		                inStream.close();
		            }
		        }
		        topics = tl;
			} catch (Exception e) {
				error(e);
			}
		}
		return topics;
	}
	
	public static class Topic {
		String id = String.format("t%d", counter.getAndIncrement()); 
		String link;
		String displayName;
		String description;
		Topic parent = null;
		int depth = 0;

		StringBuilder filterText = new StringBuilder();
		
		public Topic() {
			super();
		}

		public Topic(Topic parent, String link, String displayName, String description) {
			super();
			this.parent = parent;
			this.link = link;
			this.displayName = displayName;
			this.description = description;
		}
		
		public String getParentId() {
			if (parent == null) {
				return null;
			}
			return parent.getId();
		}

		public String getId() {
			return id;
		}

		public String getFilterText() {
			return filterText.toString();
		}

		public String getLink() {
			return link;
		}
		public String getDisplayName() {
			return displayName;
		}
		public String getDescription() {
			return description;
		}

		public int getDepth() {
			return depth;
		}
	}
	
	public static class TopicListXmlHandler extends DefaultHandler2 {
        protected static final String TOPIC = "topic"; //$NON-NLS-1$
        protected static final String TOPIC_HREF = "href"; //$NON-NLS-1$
        protected static final String TOPIC_DISPLAY_NAME = "displayName"; //$NON-NLS-1$
        protected static final String TOPIC_DESCRIPTION = "description"; //$NON-NLS-1$

        private StringBuilder textBuffer = null;
        private List<Topic> allTopics = null;
        private Stack<Topic> topicStack = new Stack<Topic>();

        public TopicListXmlHandler(List<Topic> allTopics) {
            super();
            this.allTopics = allTopics;
        }
        
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (TOPIC.equals(qName)) {
            	Topic currentTopic = new Topic();
            	if (!topicStack.isEmpty()) {
            		currentTopic.parent = topicStack.peek();
            	}
            	currentTopic.depth = topicStack.size();
        		allTopics.add(currentTopic);
            	topicStack.push(currentTopic);
            } else if (TOPIC_HREF.equals(qName) ||
            		TOPIC_DISPLAY_NAME.equals(qName) ||
            		TOPIC_DESCRIPTION.equals(qName)) {
                textBuffer = new StringBuilder();
            }
        }
        
        /* (non-Javadoc)
         * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
         */
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (textBuffer != null) {
                textBuffer.append(ch, start, length);
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (TOPIC.equals(qName)) {
            	/*Topic currentTopic = */topicStack.pop();
            } else if (TOPIC_HREF.equals(qName)) {
            	Topic currentTopic = topicStack.peek();
            	currentTopic.link = textBuffer.toString();
            	textBuffer = null;
            } else if (TOPIC_DISPLAY_NAME.equals(qName)) {
            	Topic currentTopic = topicStack.peek();
            	currentTopic.displayName = textBuffer.toString();
            	
            	//append the name to the filter text of all the ancestors.
            	for (Topic t: topicStack) {
            		if (t != currentTopic) {
                		currentTopic.filterText
                			.append(" ")
                			.append(t.getDisplayName());
            		}
            		t.filterText
            			.append(" ")
            			.append(currentTopic.displayName);
            	}
            	
            	textBuffer = null;
            } else if (TOPIC_DESCRIPTION.equals(qName)) {
            	Topic currentTopic = topicStack.peek();
                currentTopic.description = textBuffer.toString();
            	textBuffer = null;
            }
        }
    }    
	
} 