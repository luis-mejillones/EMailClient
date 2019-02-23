
package app;

import com.email.Element;
import com.email.iterator.EmailIterator;
import com.email.EmailMessage;
import com.email.Folder;
import com.email.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

import static com.email.Element.*;

public class Demo {

    public void run() {
        String searchCriteria1 = "demo01";
        String searchCriteria2 = "important";

        List<Element> emailList = this.createFakeEmails();


        List<Element> emailsFound = new ArrayList<>();
        for (Element item: emailList) {
            Visitor visitor = item.getVisitor(searchCriteria2);
            visitor.visit(item);
            List<Element> visited = visitor.getVisited();
            emailsFound.addAll(visited);
        }

        emailsFound.stream().forEach(item -> item.displayContent());

    }

    private List<Element> createFakeEmails() {
        List<Element> list = new ArrayList<>();

        Folder folderInbox = new Folder(FOLDER_INBOX_NAME);
        folderInbox.addChildElement(this.getFakeEmail01());
        folderInbox.addChildElement(this.getFakeEmail02());

        Folder folderSent = new Folder(FOLDER_SENT_NAME);
        folderSent.addChildElement(this.getFakeEmail03());

        Folder folderTrash = new Folder(FOLDER_TRASH_NAME);

        Folder folderImportant = new Folder("Important");
        folderImportant.addChildElement(this.getFakeEmail04());
        folderImportant.addChildElement(this.getFakeEmail05());

        list.add(folderInbox);
        list.add(folderSent);
        list.add(folderTrash);
        list.add(folderImportant);

        return list;
    }

    private Element getFakeEmail01() {
        Element email = new EmailMessage(
                "perico@gmail.com",
                "demo01@gmail.com",
                "2019-02-01 08:30",
                "Prueba de entrada desde demo01",
                "Contenido del mensaje demo01, inbox"
        );

        return email;
    }

    private Element getFakeEmail02() {
        Element email = new EmailMessage(
                "perico@gmail.com",
                "demo02@gmail.com",
                "2019-02-02 08:30",
                "Prueba de entrada desde demo02",
                "Contenido del mensaje demo02, diferente"
        );

        return email;
    }

    private Element getFakeEmail03() {
        Element email = new EmailMessage(
                "demo03@gmail.com",
                "perico@gmail.com",
                "2019-02-03 08:30",
                "Prueba de salida desde demo03",
                "Contenido del mensaje demo03, sent"
        );

        return email;
    }

    private Element getFakeEmail04() {
        Element email = new EmailMessage(
                "perico@gmail.com",
                "someone@gmail.com",
                "2019-02-05 08:30",
                "Prueba de entrada demo04",
                "Contenido del mensaje demo04 usando un folder no estandar, important"
        );

        return email;
    }

    private Element getFakeEmail05() {
        Element email = new EmailMessage(
                "perico@gmail.com",
                "friend@gmail.com",
                "2019-02-06 08:30",
                "Prueba de entrada demo05",
                "Contenido del mensaje demo05 usando un folder no estandar, important"
        );

        return email;
    }
}
