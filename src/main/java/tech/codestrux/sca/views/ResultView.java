package tech.codestrux.sca.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import tech.codestrux.sca.models.Prueba;

/**
 * The main view contains a button and a click listener.
 */
@Route("result")
@PageTitle("Resultados")
@PreserveOnRefresh
public class ResultView extends VerticalLayout {

    @Autowired
    Prueba prueba;

    public ResultView(Prueba prueba) {
        add(new H3("Resultados"));
        Button button = new Button("Finalizar", e -> {
            UI.getCurrent().navigate("");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        addClassName("wider-content");
    }
}
