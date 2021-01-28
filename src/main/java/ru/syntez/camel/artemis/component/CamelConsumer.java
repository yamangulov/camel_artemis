package ru.syntez.camel.artemis.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.syntez.camel.artemis.entities.RoutingDocument;

/**
 * Configuration custom CamelConsumer
 *
 * @author Skyhunter
 * @date 28.01.2021
 */
public class CamelConsumer {

    private static Logger LOG = LogManager.getLogger(CamelConsumer.class);

    private Integer delayMillis;
    public CamelConsumer(Integer delayMillis) {
        this.delayMillis = delayMillis;
    }

    private Integer consumedDocumentCount = 0;

    public void execute(RoutingDocument document) {

        LOG.info("START CONSUME MESSAGE, docId: {} docType: {}", document.getDocId(), document.getDocType());
        try {
            Thread.sleep(delayMillis);
            consumedDocumentCount++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("FINISH CONSUME MESSAGE, docId: {} docType: {}. Total consumed: {}", document.getDocId(), document.getDocType(), consumedDocumentCount);
    }
}
