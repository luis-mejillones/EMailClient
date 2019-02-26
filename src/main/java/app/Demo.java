package app;

import com.email.Element;
import com.email.EmailMessage;
import com.email.Folder;
import com.email.FolderImpl;
import com.email.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

import static com.email.Folder.FOLDER_INBOX_NAME;
import static com.email.Folder.FOLDER_SENT_NAME;
import static com.email.Folder.FOLDER_TRASH_NAME;

/**
 * Clase que se encarga de demostrar como funciona la aplicación de busqueda de correos
 * utilizando los patrones Iterator y Visitor.
 */
public class Demo {
  List<Element> emailList;

  /**
   * El constructior inizializa una lista con falsos mensajes que seran utlizados para realizar la busqueda.
   * Luego despliega la lista de correos creados.
   */
  public Demo() {
    this.emailList = this.createFakeEmails();
    System.out.println("Demo: Mensajes creados para el ejercicio:");
    this.emailList.stream().forEach(item -> item.displayContent());
  }

  /**
   * Este metodo es invocado desde la aplicación principal, recibe como parametro el texto que sea buscado.
   * Realiza la busqueda y finalmente muestra los resultados.
   *
   * @param searchCriteria
   */
  public void search(String searchCriteria) {
    System.out.println("Buscar por: '" + searchCriteria + "'");

    List<Element> emailsFound = new ArrayList<>();
    for (Element item : this.emailList) {
      Visitor visitor = ((Folder) item).getVisitor(searchCriteria);
      visitor.visit(item);
      List<Element> visited = visitor.getVisited();
      emailsFound.addAll(visited);
    }

    System.out.println("Resultados encontrados: " + emailsFound.size());
    emailsFound.stream().forEach(item -> item.displayContent());
  }

  private List<Element> createFakeEmails() {
    List<Element> list = new ArrayList<>();

    FolderImpl folderImplInbox = new FolderImpl(FOLDER_INBOX_NAME);
    folderImplInbox.addElement(this.getFakeEmail01());
    folderImplInbox.addElement(this.getFakeEmail02());

    FolderImpl folderImplSent = new FolderImpl(FOLDER_SENT_NAME);
    folderImplSent.addElement(this.getFakeEmail03());

    FolderImpl folderImplTrash = new FolderImpl(FOLDER_TRASH_NAME);

    FolderImpl folderImplImportant = new FolderImpl("Important");
    folderImplImportant.addElement(this.getFakeEmail04());
    folderImplImportant.addElement(this.getFakeEmail05());

    list.add(folderImplInbox);
    list.add(folderImplSent);
    list.add(folderImplTrash);
    list.add(folderImplImportant);

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
