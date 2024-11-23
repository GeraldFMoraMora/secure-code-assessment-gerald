package tech.codestrux.sca.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import tech.codestrux.sca.models.Prueba;

import java.util.Map;

/**
 * The main view contains a button and a click listener.
 */
@Route("result")
@PageTitle("Resultados")
@PreserveOnRefresh
public class ResultView extends VerticalLayout {

    @Autowired
    Prueba prueba;
    Prueba pruebaRespuestasCorrectasPropuestas = new Prueba();
    Prueba pruebaRespuestasCorrectasCorregidas = new Prueba();



    public ResultView(Prueba prueba) {
        this.prueba = prueba;

        pruebaRespuestasCorrectasPropuestas.setNombre("Solucion supuesta");
        inicializarRespuestasPropuestas();

        pruebaRespuestasCorrectasCorregidas.setNombre("Solucion definitiva");
        inicializarRespuestasCorregidas();

        double porcentajePropuestas = calcularPorcentajeRespuestasCorrectas(
                prueba.getRespuestas(),
                pruebaRespuestasCorrectasPropuestas.getRespuestas()
        );

        double porcentajeCorregidas = calcularPorcentajeRespuestasCorrectas(
                prueba.getRespuestas(),
                pruebaRespuestasCorrectasCorregidas.getRespuestas()
        );
        add(new H3("Resultados"));
        Button button = new Button("Finalizar", e -> {
            UI.getCurrent().navigate("");
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);

        // Mostrar resultados
        add(new H4("Porcentaje de respuestas correctas (Solución supuesta): "
                + porcentajePropuestas + "%"));
        add(new H4("Porcentaje de respuestas correctas (Solución definitiva): "
                + porcentajeCorregidas + "%"));


        addClassName("wider-content");
    }

    private void inicializarRespuestasPropuestas(){
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(1,"b) Confidencialidad");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(2,"b) Usar más de un método de verificación para acceder al sistema");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(3,"b) Restringir a los usuarios únicamente a las funciones necesarias para realizar su trabajo");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(4,"b) Falta de sanitización en la entrada del usuario");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(5,"a) Usar HTTPS");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(6,"a) Control de acceso basado en roles (RBAC)");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(7,"b) Usar un algoritmo hash con sal (salted hashing)");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(8,"b) Un encabezado que especifica qué recursos pueden cargarse en una página web");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(9,"b) Para minimizar la superficie de ataque");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(10,"b) Documentarla y solucionarla lo antes posible");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(11,"b) Implementar un sistema de revisión periódica para identificar amenazas y actividades " +
                "sospechosas en tiempo real");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(12,"b) ISO/IEC 27001");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(13,"b) Un ataque DoS al servidor");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(14,"c) Ataque DDoS - Usar un balanceador de carga o WAF");
        pruebaRespuestasCorrectasPropuestas.getRespuestas().put(15,"b) Usar tokens únicos que se validen en cada solicitud");
    }

    private void inicializarRespuestasCorregidas() {
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(1,"b) Confidencialidad");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(2,"b) Usar más de un método de verificación para acceder al sistema");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(3,"b) Restringir a los usuarios únicamente a las funciones necesarias para realizar su trabajo");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(4,"b) Falta de sanitización en la entrada del usuario");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(5,"b) Codificar correctamente las entradas del usuario al renderizarlas");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(6,"b) Configuración de cortafuegos");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(7,"b) Usar un algoritmo hash con sal (salted hashing)");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(8,"b) Un encabezado que especifica qué recursos pueden cargarse en una página web");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(9,"b) Para minimizar la superficie de ataque");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(10,"b) Documentarla y solucionarla lo antes posible");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(11,"b) Implementar un sistema de revisión periódica para identificar amenazas y actividades " +
                "sospechosas en tiempo real");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(12,"b) ISO/IEC 27001");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(13,"b) Un ataque DoS al servidor");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(14,"b) Ataque de fuerza bruta - Implementar MFA");
        pruebaRespuestasCorrectasCorregidas.getRespuestas().put(15,"b) Usar tokens únicos que se validen en cada solicitud");
    }

    private double calcularPorcentajeRespuestasCorrectas(
            Map<Integer, String> respuestasUsuario,
            Map<Integer, String> respuestasCorrectas) {
        int totalPreguntas = respuestasCorrectas.size();
        int correctas = 0;

        for (Map.Entry<Integer, String> entry : respuestasUsuario.entrySet()) {
            Integer pregunta = entry.getKey();
            String respuestaUsuario = entry.getValue();

            if (respuestasCorrectas.containsKey(pregunta) &&
                    respuestasCorrectas.get(pregunta).equals(respuestaUsuario)) {
                correctas++;
            }
        }

        return (correctas * 100.0) / totalPreguntas;
    }
}
