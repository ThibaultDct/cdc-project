package com.api.cdcapi.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.api.cdcapi.business.*;
import com.api.cdcapi.business.enums.ArmorType;
import com.api.cdcapi.services.PlayerService;
import com.api.cdcapi.services.TeamService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
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

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    List<Player> players = new ArrayList<>();
    Team team1 = new Team();
    Team team2 = new Team();

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service, @Autowired ComponentHelpers componentHelpers) {

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        VerticalLayout verticalLayout = new VerticalLayout();

        // ##### TEXT BOX ##### //
        // Use TextField for standard text input
        TextField lastname = new TextField("Lastname");
        lastname.addThemeName("bordered");

        TextField firstname = new TextField("Firstname");
        firstname.addThemeName("bordered");

        TextField weapon = new TextField("Weapon");
        weapon.addThemeName("bordered");

        Map<String, Category> categories = new HashMap<>();
        categories.put("Poids Mouche", new Category("Poids Mouche", 0, 52));
        categories.put("Poids Plume", new Category("Poids Plume", 53, 57));
        categories.put("Poids Léger", new Category("Poids Léger", 58, 63));
        categories.put("Poids Welter", new Category("Poids Welter", 64, 69));
        categories.put("Poids Moyen", new Category("Poids Moyen", 70, 75));
        categories.put("Poids Mi-Lourd", new Category("Poids Mi-Lourd", 76, 81));
        categories.put("Poids Lourd", new Category("Poids Lourd", 82, 91));
        categories.put("Poids Super-Lourd", new Category("Poids Super-Lourd", 92, 100));
        Select<String> categorySelect = new Select<>();
        categorySelect.setItems(categories.keySet());
        categorySelect.setPlaceholder("Category");
        Category selectedCategory = categories.get(categorySelect.getValue());

        Map<String, Armor> armors = new HashMap<>();
        armors.put("Gambison", new Armor(ArmorType.GAMBISON));
        armors.put("Mailles", new Armor(ArmorType.MAILLES));
        armors.put("Plaques", new Armor(ArmorType.PLAQUES));
        Select<String> armorSelect = new Select<>();
        armorSelect.setItems(armors.keySet());
        armorSelect.setPlaceholder("Armor");
        Armor selectedArmor = armors.get(armorSelect.getValue());

        IntegerField age = new IntegerField("Âge");
        IntegerField seniority = new IntegerField("Ancienneté");
        Checkbox is_member = new Checkbox();
        is_member.setLabel("Membre");
        is_member.setValue(false);

        // ##### LIST PLAYERS ##### //
        List<Player> playerList = new ArrayList<>();

        Grid<Player> grid = new Grid<>(Player.class);
        Div gridDiv = new Div();
        grid.setItems(players);

        grid.removeColumnByKey("player_id");

        // The Grid<>(Person.class) sorts the properties and in order to
        // reorder the properties we use the 'setColumns' method.
        grid.setColumns("lastname", "firstname", "category", "weapon",
                "armor", "age", "seniority", "is_member");
        add(grid, gridDiv);

        // ##### TEAMS ##### //
        HorizontalLayout teamsLayout = new HorizontalLayout();
        Accordion accordion = new Accordion();
        Grid<Player> team1Grid = new Grid<>(Player.class);
        Grid<Player> team2Grid = new Grid<>(Player.class);
        team1Grid.setItems(team1.getPlayers());
        team1Grid.removeColumnByKey("player_id");
        team1Grid.setColumns("lastname", "firstname", "category", "weapon",
                "armor", "age", "seniority", "is_member");
        team2Grid.setItems(team2.getPlayers());
        team2Grid.removeColumnByKey("player_id");
        team2Grid.setColumns("lastname", "firstname", "category", "weapon",
                "armor", "age", "seniority", "is_member");

        accordion.add("Joueurs en attente", grid);
        accordion.add("Équipe 1", team1Grid);
        accordion.add("Équipe 2", team2Grid);
        accordion.setWidthFull();

        // Button click listeners can be defined as lambda expressions
        Button button = new Button("Ajouter joueur", e -> {
            Notification.show("Joueur " + lastname.getValue() + " " + firstname.getValue() + " ajouté !");
            players.add(playerService.createPlayer(lastname.getValue(), firstname.getValue(), categories.get(categorySelect.getValue()), new Weapon(weapon.getValue()), armors.get(armorSelect.getValue()), age.getValue(), seniority.getValue(), is_member.getValue()));
            grid.getDataProvider().refreshAll();
        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickShortcut(Key.ENTER);
        addClassName("centered-content");

        horizontalLayout.add(lastname, firstname, weapon, age, seniority);
        horizontalLayout2.add(categorySelect, armorSelect, is_member, button);

        verticalLayout.add(accordion);
        verticalLayout.add(horizontalLayout);
        verticalLayout.add(horizontalLayout2);
        verticalLayout.add(teamsLayout);

        // Button click listeners can be defined as lambda expressions
        Button sortTeams = new Button("Créer équipes", e -> {
            Notification.show("Création des équipes...");
            teamService.createTeams(team1, team2, players);
            grid.getDataProvider().refreshAll();
            team1Grid.getDataProvider().refreshAll();
            team2Grid.getDataProvider().refreshAll();
        });

        verticalLayout.add(sortTeams);

        add(verticalLayout);
        
    }

}