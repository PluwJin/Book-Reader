
package yazılım_lab_1;

import java.awt.Dimension;
import static java.awt.SystemColor.window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.core.util.content.*;

// KİTAP PDFLERİNİN GÖSTERİMİ İÇİN ICEPDF KÜTÜPHANESİ KULLANILMIŞTIR  JFRAME OLUŞTURUUR VE PDF GÖSTERİLİR KULLANCININ SEÇTİĞİ KİTABIN İSBNSİNİN SON KARAKTERİNE GÖRE ALTI
// ALTI FARKLI KİTAP AÇILIR
public class denemeee {
    public denemeee(String kitap_no){
    String filePath =kitap_no;

SwingController controller = new SwingController();


SwingViewBuilder factory = new SwingViewBuilder(controller);

JPanel viewerComponentPanel = factory.buildViewerPanel();


ComponentKeyBinding.install(controller, viewerComponentPanel);


controller.getDocumentViewController().setAnnotationCallback(
      new org.icepdf.ri.common.MyAnnotationCallback(
             controller.getDocumentViewController()));

JFrame window = new JFrame("Using the Viewer Component");


window.setTitle("Reading");

window.setExtendedState(JFrame.MAXIMIZED_BOTH);
window.setExtendedState(window.EXIT_ON_CLOSE);
window.getContentPane().add(viewerComponentPanel);
window.pack();
window.setVisible(true);

controller.openDocument(filePath);
        
    }
    
    public static void main(String[] args) {
        new denemeee("s.pdf");
    }
}
