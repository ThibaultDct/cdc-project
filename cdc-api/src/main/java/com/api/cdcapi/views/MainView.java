package com.api.cdcapi.views;

import java.util.ArrayList;
import java.util.List;

import com.api.cdcapi.business.Armor;
import com.api.cdcapi.business.Category;
import com.api.cdcapi.business.Player;
import com.api.cdcapi.business.Weapon;
import com.api.cdcapi.business.enums.ArmorType;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.")
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout implements AppShellConfigurator {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service, @Autowired ComponentHelpers componentHelpers) {

        Div addPlayerForm = new Div();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        // ##### TEXT BOX ##### //
        // Use TextField for standard text input
        TextField lastname = new TextField("Lastname");
        lastname.addThemeName("bordered");

        TextField firstname = new TextField("Firstname");
        firstname.addThemeName("bordered");

        List<String> categories = new ArrayList<>();
        categories.add(new Category("Poids Mouche", 0, 52).toString());
        categories.add(new Category("Poids Plume", 53, 57).toString());
        categories.add(new Category("Poids Léger", 58, 63).toString());
        categories.add(new Category("Poids Welter", 64, 69).toString());
        categories.add(new Category("Poids Moyen", 70, 75).toString());
        categories.add(new Category("Poids Mi-Lourd", 76, 81).toString());
        categories.add(new Category("Poids Lourd", 82, 91).toString());
        categories.add(new Category("Poids Super-Lourd", 92, 100).toString());
        Select<String> categorySelect = new Select<>();
        categorySelect.setItems(categories.stream());
        categorySelect.setPlaceholder("Category");

        Select<String> armorSelect = new Select<>();
        armorSelect.setItems(ArmorType.GAMBISON.toString(), ArmorType.MAILLES.toString(), ArmorType.PLAQUES.toString());
        armorSelect.setPlaceholder("Armor");

        // Button click listeners can be defined as lambda expressions
        Button button = new Button("Say hello",
                e -> Notification.show(service.greet(firstname.getValue() + " " + lastname.getValue())));

        // Theme variants give you predefined extra styles for components.
        // Example: Primary button has a more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        button.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");

        horizontalLayout.add(lastname, firstname, categorySelect, armorSelect, button);
        add(horizontalLayout);

        // ##### UPLOAD COMPONENT ##### //
        // MemoryBuffer buffer = new MemoryBuffer();
        // Upload upload = new Upload(buffer);
        // Div output = new Div();

        // upload.addSucceededListener(event -> {
        //     Component component = componentHelpers.createComponent(event.getMIMEType(),
        //             event.getFileName(), buffer.getInputStream());
        //     output.removeAll();
        //     componentHelpers.showOutput(event.getFileName(), component, output);
        // });

        // upload.addFileRejectedListener(event -> {
        //     Paragraph component = new Paragraph();
        //     output.removeAll();
        //     componentHelpers.showOutput(event.getErrorMessage(), component, output);
        // });
        // upload.getElement().addEventListener("file-remove", event -> {
        //     output.removeAll();
        // });

        // add(upload, output);

        // ##### LIST PLAYERS ##### //
        List<Player> playerList = new ArrayList<>();

        playerList.add(new Player("ERNAULT", "Alexandre", new Category("Poids Moyen", 75, 80), new Weapon("Lance"), new Armor(ArmorType.GAMBISON), 54, 20, true));
        playerList.add(new Player("DOUCET", "Thibault", new Category("Poids Léger", 63, 68), new Weapon("Bâton de mage"), new Armor(ArmorType.MAILLES), 24, 6, true));
        playerList.add(new Player("MOREL", "Alban", new Category("Poids Plume", 57, 62), new Weapon("Mousquet"), new Armor(ArmorType.PLAQUES), 16, 1, false));
        playerList.add(new Player("BOUTIN", "Florian", new Category("Poids Super-Lourd", 91, 100), new Weapon("Poings"), new Armor(ArmorType.GAMBISON), 6, 0, false));

        Grid<Player> grid = new Grid<>(Player.class);
        Div gridDiv = new Div();
        grid.setItems(playerList);

        grid.removeColumnByKey("player_id");

        // The Grid<>(Person.class) sorts the properties and in order to
        // reorder the properties we use the 'setColumns' method.
        grid.setColumns("lastname", "firstname", "category", "weapon",
                "armor", "age", "seniority", "is_member");
        add(grid, gridDiv);
        
    }

}