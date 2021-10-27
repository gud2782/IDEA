package com.likeadog.idea.api;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;

@Component
public class PublicAPI {

    public String callAPI(String regId, String name){
        BufferedReader br = null;

        //DocumentBuilderFactory 생성
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            //OpenApi호출
            //호출할 URL 조립
            StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/animalInfoSrvc/animalInfo"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=7IMlkzJ1Zq8JQf3Ot8C2hwSdWtXywQKijtFAC%2BqK70pyXsPHVeRtwyhs8I4CP2vUavKuP8Muf2Q23Qx4k5C90g%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("dog_reg_no","UTF-8") + "=" + URLEncoder.encode(regId, "UTF-8")); /*동물등록번호*/
            urlBuilder.append("&" + URLEncoder.encode("owner_nm","UTF-8") + "=" + URLEncoder.encode(name, "UTF-8")); /*소유자 성명*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

            //응답 읽기
            br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
            String result = "";
            String line;
            while ((line = br.readLine()) != null) {
                result = result + line.trim();// result = URL로 XML을 읽은 값
            }

            // xml 파싱하기
            InputSource is = new InputSource(new StringReader(result));
            builder = factory.newDocumentBuilder();

            doc = builder.parse(is);


            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            XPathExpression expr = xpath.compile("//body/item");
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            //값 저장용 변수
            String aniName="";
            String regNo ="";
            String kindNm ="";
            String neuterYn="";
            String sexNm ="";

            for (int i = 0; i < nodeList.getLength(); i++) {
                NodeList child = nodeList.item(i).getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    if (j == 1) {
                        aniName = node.getTextContent();
                    } else if(j==2){
                        regNo = node.getTextContent();
                    } else if(j==3){
                        kindNm =node.getTextContent();
                    } else if(j==4){
                        neuterYn =node.getTextContent();
                    } else if(j==8){
                        sexNm =node.getTextContent();
                    }

                }
            }


            return aniName+","+regNo+","+kindNm+","+neuterYn+","+sexNm;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}