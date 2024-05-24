//package code.shubham.parsers.handlers;
//
//import lombok.extern.slf4j.Slf4j;
//import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;
//import org.xml.sax.helpers.DefaultHandler;
//
//import java.util.ArrayList;
//
//@Slf4j
//public class ParserHandler extends DefaultHandler {
//    private static final String ARTICLES = "articles";
//    private static final String ARTICLE = "article";
//    private static final String TITLE = "title";
//    private static final String CONTENT = "content";
//
//    private Baeldung website;
//    private StringBuilder elementValue;
//
//    @Override
//    public void characters(char[] ch, int start, int length) throws SAXException {
//        if (elementValue == null) {
//            elementValue = new StringBuilder();
//        } else {
//            elementValue.append(ch, start, length);
//        }
//    }
//
//    @Override
//    public void startDocument() throws SAXException {
//        website = new Baeldung();
//    }
//
//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        switch (qName) {
//            case ARTICLES:
//                website.articleList = new ArrayList<>();
//                break;
//            case ARTICLE:
//                website.articleList.add(new BaeldungArticle());
//                break;
//            case TITLE:
//                elementValue = new StringBuilder();
//                break;
//            case CONTENT:
//                elementValue = new StringBuilder();
//                break;
//        }
//    }
//
//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        switch (qName) {
//            case TITLE:
//                latestArticle().setTitle(elementValue.toString());
//                break;
//            case CONTENT:
//                latestArticle().setContent(elementValue.toString());
//                break;
//        }
//    }
//
//    private BaeldungArticle latestArticle() {
//        List<BaeldungArticle> articleList = website.articleList;
//        int latestArticleIndex = articleList.size() - 1;
//        return articleList.get(latestArticleIndex);
//    }
//
//    public Baeldung getWebsite() {
//        return website;
//    }
//}
