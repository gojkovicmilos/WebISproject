package lms.utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class FOPPdfDemo {

    
    /**
     * Method that will convert the given XML to PDF 
     * @throws IOException
     * @throws FOPException
     * @throws TransformerException
     */
    public Path convertToPDF(Path filepath, String filename)  throws IOException, FOPException, TransformerException {
        // the XSL FO file
        File xsltFile = new File("F:\\Temp\\template.xsl");
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(filepath.toFile());
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        File file = new File(filename);

        FileOutputStream out = new java.io.FileOutputStream(file);
    
        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then 
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            
            out.close();
        }

        return file.toPath();
    }
    
    /**
     * This method will convert the given XML to XSL-FO
     * @throws IOException
     * @throws FOPException
     * @throws TransformerException
     */
    public void convertToFO(String filename)  throws IOException, FOPException, TransformerException {
        // the XSL FO file
        File xsltFile = new File("F:\\Temp\\template.xsl");
            
        /*TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource
          ("F:\\Temp\\template.xsl"));*/
        
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File(filename));
        
        // a user agent is needed for transformation
        /*FOUserAgent foUserAgent = fopFactory.newFOUserAgent();*/
        // Setup output
        OutputStream out;
        
        out = new java.io.FileOutputStream("F:\\Temp\\temp.fo");
    
        try {
            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            //Result res = new SAXResult(fop.getDefaultHandler());

            Result res = new StreamResult(out);

            //Start XSLT transformation and FOP processing
            transformer.transform(xmlSource, res);


            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then 
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }
}