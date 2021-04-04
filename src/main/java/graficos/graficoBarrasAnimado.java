package graficos;

import gestion.GraficoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import model.Grafico;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Grupo 7
 */
@Named(value = "graficoBarrasAnimado")
@SessionScoped
public class graficoBarrasAnimado implements Serializable {

    private BarChartModel animatedModel;

    @PostConstruct
    public void init() {
        createAnimatedModels();
    }

    public BarChartModel getAnimatedModel2() {
        return animatedModel;
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();

        // Inicializar cada serie
        ChartSeries modecUx = new ChartSeries();
        modecUx.setLabel("Modec UX");
        ChartSeries modecUx2 = new ChartSeries();
        modecUx2.setLabel("Modec UX2");
        ChartSeries modecUx3 = new ChartSeries();
        modecUx3.setLabel("Modec UX3");
        ChartSeries modecMx = new ChartSeries();
        modecMx.setLabel("Modec MX");
        ChartSeries modecSp = new ChartSeries();
        modecSp.setLabel("Modec SP");
        ChartSeries modecSp2 = new ChartSeries();
        modecSp2.setLabel("Modec SP2");
        ChartSeries modecSp3 = new ChartSeries();
        modecSp3.setLabel("Modec SP3");
        ChartSeries modecSp4 = new ChartSeries();
        modecSp4.setLabel("Modec SP4");
        ChartSeries modecSp5 = new ChartSeries();
        modecSp5.setLabel("Modec SP5");
        ChartSeries modecSp6 = new ChartSeries();
        modecSp6.setLabel("Modec SP6");
        ChartSeries redHoodie = new ChartSeries();
        redHoodie.setLabel("Red Hoodie");
        ChartSeries greySweater = new ChartSeries();
        greySweater.setLabel("Grey Sweater");

        // Llamada a la DB
        ArrayList<Grafico> list = GraficoGestion.getCountArticulosCarrito();

        for (Grafico row : list) {
            if (row.getNombre_articulo().equalsIgnoreCase("Modec UX")) {
                modecUx.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Modec UX2")) {
                modecUx2.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Modec UX3")) {
                modecUx3.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Modec MX")) {
                modecMx.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Modec SP")) {
                modecSp.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Modec SP2")) {
                modecSp2.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Modec SP3")) {
                modecSp3.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Modec SP4")) {
                modecSp4.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Modec SP5")) {
                modecSp5.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Modec SP6")) {
                modecSp6.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Red Hoodie")) {
                redHoodie.set("Productos", row.getTotal());
            }
            if (row.getNombre_articulo().equalsIgnoreCase("Grey Sweater")) {
                greySweater.set("Productos", row.getTotal());
            }
        }

        // Agrego las series al grafico
        model.addSeries(modecUx);
        model.addSeries(modecUx2);
        model.addSeries(modecUx3);
        model.addSeries(modecMx);
        model.addSeries(modecSp);
        model.addSeries(modecSp2);
        model.addSeries(modecSp3);
        model.addSeries(modecSp4);
        model.addSeries(modecSp5);
        model.addSeries(modecSp6);
        model.addSeries(redHoodie);
        model.addSeries(greySweater); 

        return model;
    }

    private void createAnimatedModels() {
        animatedModel = initBarModel();
        animatedModel.setTitle("Articulos Carrito");
        animatedModel.setAnimate(true);
        animatedModel.setBarWidth(55); 
        animatedModel.setBarPadding(14);
        animatedModel.setLegendPosition("ne");
    }

}
