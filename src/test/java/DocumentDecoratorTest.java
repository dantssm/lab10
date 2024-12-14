import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import ua.edu.ucu.apps.decorator.CashedDocument;
import ua.edu.ucu.apps.decorator.DBConnection;
import ua.edu.ucu.apps.decorator.Document;
import ua.edu.ucu.apps.decorator.MockedDocument;
import ua.edu.ucu.apps.decorator.TimedDocument;

import org.junit.jupiter.api.Assertions;

public class DocumentDecoratorTest {

    @Test
    void testCashedDocument() {
        DBConnection mockDb = Mockito.mock(DBConnection.class);
        Document mockDocument = Mockito.mock(Document.class);

        try (MockedStatic<DBConnection> DB_CONNECTION_MOCK
                = Mockito.mockStatic(DBConnection.class)) {
            DB_CONNECTION_MOCK.when(DBConnection::getInstance)
                              .thenReturn(mockDb);

            Mockito.when(mockDocument.getGcsPath()).thenReturn("somePath");
            Mockito.when(mockDocument.parse()).thenReturn("Parsed Content");

            Mockito.when(mockDb.getDocument("somePath"))
                   .thenReturn("Cached Content");

            CashedDocument cashedDocument = new CashedDocument(mockDocument);

            String cached = cashedDocument.parse();
            Assertions.assertEquals("Cached Content", cached);

            Mockito.verify(mockDb, Mockito.times(1))
                   .getDocument("somePath");
            Mockito.verify(mockDocument, Mockito.never()).parse();
        }
    }

    @Test
    void testTimedDocument() {
        Document mockDocument = Mockito.mock(Document.class);
        Mockito.when(mockDocument.getGcsPath()).thenReturn("somePath");
        Mockito.when(mockDocument.parse()).thenReturn("Parsed Content");

        TimedDocument timedDocument = new TimedDocument(mockDocument);

        String result = timedDocument.parse();
        Assertions.assertEquals("Parsed Content", result);

        Mockito.verify(mockDocument, Mockito.times(1)).parse();
    }

    @Test
    void testMockedDocument() {
        MockedDocument mockedDocument = new MockedDocument("mockPath");

        String parsedContent = mockedDocument.parse();
        Assertions.assertEquals("Mocked Document Parse", parsedContent);
    }
}
