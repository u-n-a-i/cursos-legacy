import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class IconosPersonalizados extends DefaultTreeCellRenderer {

    private Icon iconoCarpeta;
    private Icon iconoArchivo;

    public IconosPersonalizados() {
        // icono de carpeta
        Image imgCarpeta = new ImageIcon(getClass().getResource("/iconos/carpeta.png"))
                .getImage()
                .getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        iconoCarpeta = new ImageIcon(imgCarpeta);

        // icono de archivo
        Image imgArchivo = new ImageIcon(getClass().getResource("/iconos/archivo.png"))
                .getImage()
                .getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        iconoArchivo = new ImageIcon(imgArchivo);
    }

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree, Object value, boolean sel, boolean expanded,
            boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if (leaf) {
            setIcon(iconoArchivo);
        } else {
            setIcon(iconoCarpeta);
        }

        return this;
    }
}
