package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Mneu_Interface {
    
    // Enumeración para los tipos de usuarios
    public enum UserRole {
        ADMINISTRATOR, EMPLOYEE, CUSTOMER
    }
    
    // Clase para representar usuarios
    public static class User {
        private String username;
        private String password;
        private UserRole role;
        
        public User(String username, String password, UserRole role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }
        
        public String getUsername() { return username; }
        public String getPassword() { return password; }
        public UserRole getRole() { return role; }
    }
    
    // Base de datos simulada de usuarios
    private static Map<String, User> users = new HashMap<>();
    
    // Inicializar usuarios de prueba
    static {
        users.put("admin", new User("admin", "admin123", UserRole.ADMINISTRATOR));
        users.put("empleado", new User("empleado", "emp123", UserRole.EMPLOYEE));
        users.put("cliente", new User("cliente", "cli123", UserRole.CUSTOMER));
    }
    
    private static User currentUser = null;
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            showLoginScreen();
        });
    }
    
    // Mostrar pantalla de login
    private static void showLoginScreen() {
        JFrame loginFrame = new JFrame("Login - Sistema de Gestión de Restaurante");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 200);
        loginFrame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField();
        
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        
        JButton loginButton = new JButton("Iniciar Sesión");
        JButton cancelButton = new JButton("Cancelar");
        
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(loginButton);
        panel.add(cancelButton);
        
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            
            if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
                currentUser = users.get(username);
                loginFrame.dispose();
                showMainMenu();
            } else {
                JOptionPane.showMessageDialog(loginFrame, 
                    "Usuario o contraseña incorrectos", 
                    "Error de autenticación", 
                    JOptionPane.ERROR_MESSAGE);
            }
        });
        
        cancelButton.addActionListener(e -> {
            System.exit(0);
        });
        
        loginFrame.add(panel);
        loginFrame.setVisible(true);
    }
    
    // Mostrar menú principal basado en el rol del usuario
    private static void showMainMenu() {
        JFrame mainFrame = new JFrame("Sistema de Gestión de Restaurante");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 600);
        mainFrame.setLocationRelativeTo(null);
        
        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Barra superior con información del usuario
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.setBackground(new Color(230, 230, 250));
        JLabel welcomeLabel = new JLabel("Bienvenido/a, " + currentUser.getUsername() + " (" + currentUser.getRole() + ")");
        JButton logoutButton = new JButton("Cerrar Sesión");
        topPanel.add(welcomeLabel, BorderLayout.WEST);
        topPanel.add(logoutButton, BorderLayout.EAST);
        
        // Panel lateral de menú
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        menuPanel.setPreferredSize(new Dimension(200, 500));
        menuPanel.setBackground(new Color(240, 240, 240));
        
        // Panel de contenido principal (cambiará según la opción seleccionada)
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Agregar elementos de menú según el rol del usuario
        addMenuItems(menuPanel, contentPanel);
        
        // Configurar el panel principal
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        // Agregar panel principal al frame
        mainFrame.add(mainPanel);
        
        // Funcionalidad de cerrar sesión
        logoutButton.addActionListener(e -> {
            currentUser = null;
            mainFrame.dispose();
            showLoginScreen();
        });
        
        mainFrame.setVisible(true);
    }
    
    // Agregar elementos de menú según el rol del usuario
    private static void addMenuItems(JPanel menuPanel, JPanel contentPanel) {
        // Crear un panel de bienvenida por defecto
        JPanel welcomePanel = new JPanel(new BorderLayout());
        JLabel welcomeMessage = new JLabel(
            "<html><h1>Bienvenido al Sistema de Gestión de Restaurante</h1>" +
            "<p>Seleccione una opción del menú para comenzar.</p></html>");
        welcomePanel.add(welcomeMessage, BorderLayout.CENTER);
        contentPanel.add(welcomePanel, "welcome");
        
        // Mostrar opciones según el rol del usuario
        switch (currentUser.getRole()) {
            case ADMINISTRATOR:
                addAdminMenuItems(menuPanel, contentPanel);
                break;
            case EMPLOYEE:
                addEmployeeMenuItems(menuPanel, contentPanel);
                break;
            case CUSTOMER:
                addCustomerMenuItems(menuPanel, contentPanel);
                break;
        }
        
        // Asegurarse de que el panel de bienvenida sea visible inicialmente
        ((CardLayout)contentPanel.getLayout()).show(contentPanel, "welcome");
    }
    
    // Opciones de menú para administradores
    private static void addAdminMenuItems(JPanel menuPanel, JPanel contentPanel) {
        addMenuItem(menuPanel, contentPanel, "Gestión de Empleados", createEmployeeManagementPanel());
        addMenuItem(menuPanel, contentPanel, "Gestión de Proveedores", createSupplierManagementPanel());
        addMenuItem(menuPanel, contentPanel, "Gestión de Mesas", createTableManagementPanel());
        addMenuItem(menuPanel, contentPanel, "Gestión de Menú", createMenuManagementPanel());
        addMenuItem(menuPanel, contentPanel, "Gestión de Reservas", createReservationManagementPanel());
        addMenuItem(menuPanel, contentPanel, "Gestión de Ventas", createSalesManagementPanel());
        addMenuItem(menuPanel, contentPanel, "Gestión de Inventario", createInventoryManagementPanel());
    }
    
    // Opciones de menú para empleados
    private static void addEmployeeMenuItems(JPanel menuPanel, JPanel contentPanel) {
        addMenuItem(menuPanel, contentPanel, "Gestión de Mesas", createTableManagementPanel());
        addMenuItem(menuPanel, contentPanel, "Gestión de Menú", createMenuManagementPanel());
        addMenuItem(menuPanel, contentPanel, "Gestión de Reservas", createReservationManagementPanel());
        addMenuItem(menuPanel, contentPanel, "Gestión de Ventas", createSalesManagementPanel());
    }
    
    // Opciones de menú para clientes
    private static void addCustomerMenuItems(JPanel menuPanel, JPanel contentPanel) {
        addMenuItem(menuPanel, contentPanel, "Ver Menú", createMenuViewPanel());
        addMenuItem(menuPanel, contentPanel, "Hacer Reserva", createMakeReservationPanel());
    }
    
    // Método para agregar un elemento de menú
    private static void addMenuItem(JPanel menuPanel, JPanel contentPanel, String title, JPanel panel) {
        JButton menuButton = new JButton(title);
        menuButton.setMaximumSize(new Dimension(180, 40));
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.setBackground(new Color(200, 200, 200));
        
        menuButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentPanel.getLayout();
            cl.show(contentPanel, title);
        });
        
        // Agregar espacio entre botones
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        menuPanel.add(menuButton);
        
        // Agregar el panel correspondiente al panel de contenido
        contentPanel.add(panel, title);
    }
    
    // Integración con las clases existentes
    
    private static JPanel createEmployeeManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Gestión de Empleados", SwingConstants.CENTER), BorderLayout.NORTH);
        
        JButton addButton = new JButton("Agregar Empleado");
        JButton editButton = new JButton("Editar Empleado");
        JButton deleteButton = new JButton("Eliminar Empleado");
        JButton listButton = new JButton("Listar Empleados");
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);
        
        JTextArea outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Conectar con la clase existente
        addButton.addActionListener(e -> {
            // Aquí se conectaría con tu clase de gestión de empleados
            // Por ejemplo: new EmpleadoMenu().menuAgregarEmpleado();
            outputArea.setText("Función para agregar empleado");
        });
        
        editButton.addActionListener(e -> {
            // Conexión con la funcionalidad de editar empleado
            outputArea.setText("Función para editar empleado");
        });
        
        deleteButton.addActionListener(e -> {
            // Conexión con la funcionalidad de eliminar empleado
            outputArea.setText("Función para eliminar empleado");
        });
        
        listButton.addActionListener(e -> {
            // Conexión con la funcionalidad de listar empleados
            outputArea.setText("Función para listar empleados");
        });
        
        return panel;
    }
    
    private static JPanel createSupplierManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Gestión de Proveedores", SwingConstants.CENTER), BorderLayout.NORTH);
        
        JButton addButton = new JButton("Agregar Proveedor");
        JButton editButton = new JButton("Editar Proveedor");
        JButton deleteButton = new JButton("Eliminar Proveedor");
        JButton listButton = new JButton("Listar Proveedores");
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);
        
        JTextArea outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Conectar con la clase existente
        addButton.addActionListener(e -> {
            // Aquí se conectaría con tu clase de gestión de proveedores
            // Por ejemplo: new ProveedorMenu().menuAgregarProveedor();
            outputArea.setText("Función para agregar proveedor");
        });
        
        editButton.addActionListener(e -> {
            outputArea.setText("Función para editar proveedor");
        });
        
        deleteButton.addActionListener(e -> {
            outputArea.setText("Función para eliminar proveedor");
        });
        
        listButton.addActionListener(e -> {
            outputArea.setText("Función para listar proveedores");
        });
        
        return panel;
    }
    
    private static JPanel createTableManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Gestión de Mesas", SwingConstants.CENTER), BorderLayout.NORTH);
        
        JButton addButton = new JButton("Agregar Mesa");
        JButton editButton = new JButton("Editar Mesa");
        JButton deleteButton = new JButton("Eliminar Mesa");
        JButton listButton = new JButton("Listar Mesas");
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);
        
        JTextArea outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Conectar con la clase existente
        addButton.addActionListener(e -> {
            // Aquí se conectaría con tu clase de gestión de mesas
            // Por ejemplo: new MesaMenu().menuAgregarMesa();
            outputArea.setText("Función para agregar mesa");
        });
        
        editButton.addActionListener(e -> {
            outputArea.setText("Función para editar mesa");
        });
        
        deleteButton.addActionListener(e -> {
            outputArea.setText("Función para eliminar mesa");
        });
        
        listButton.addActionListener(e -> {
            outputArea.setText("Función para listar mesas");
        });
        
        return panel;
    }
    
    private static JPanel createMenuManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Gestión de Menú", SwingConstants.CENTER), BorderLayout.NORTH);
        
        JButton addButton = new JButton("Agregar Plato");
        JButton editButton = new JButton("Editar Plato");
        JButton deleteButton = new JButton("Eliminar Plato");
        JButton listButton = new JButton("Listar Menú");
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);
        
        JTextArea outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Conectar con la clase existente
        addButton.addActionListener(e -> {
            // Aquí se conectaría con tu clase de gestión de menú
            // Por ejemplo: new MenuRestaurante().menuAgregarPlato();
            outputArea.setText("Función para agregar plato al menú");
        });
        
        editButton.addActionListener(e -> {
            outputArea.setText("Función para editar plato del menú");
        });
        
        deleteButton.addActionListener(e -> {
            outputArea.setText("Función para eliminar plato del menú");
        });
        
        listButton.addActionListener(e -> {
            outputArea.setText("Función para listar el menú");
        });
        
        return panel;
    }
    
    private static JPanel createReservationManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Gestión de Reservas", SwingConstants.CENTER), BorderLayout.NORTH);
        
        JButton addButton = new JButton("Agregar Reserva");
        JButton editButton = new JButton("Editar Reserva");
        JButton deleteButton = new JButton("Cancelar Reserva");
        JButton listButton = new JButton("Listar Reservas");
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);
        
        JTextArea outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Conectar con la clase existente
        addButton.addActionListener(e -> {
            // Aquí se conectaría con tu clase de gestión de reservas
            // Por ejemplo: new ReservaMenu().menuAgregarReserva();
            outputArea.setText("Función para agregar reserva");
        });
        
        editButton.addActionListener(e -> {
            outputArea.setText("Función para editar reserva");
        });
        
        deleteButton.addActionListener(e -> {
            outputArea.setText("Función para cancelar reserva");
        });
        
        listButton.addActionListener(e -> {
            outputArea.setText("Función para listar reservas");
        });
        
        return panel;
    }
    
    private static JPanel createSalesManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Gestión de Ventas", SwingConstants.CENTER), BorderLayout.NORTH);
        
        JButton newSaleButton = new JButton("Nueva Venta");
        JButton viewSalesButton = new JButton("Ver Ventas");
        JButton reportButton = new JButton("Generar Reporte");
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(newSaleButton);
        buttonPanel.add(viewSalesButton);
        buttonPanel.add(reportButton);
        
        JTextArea outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Conectar con la clase existente
        newSaleButton.addActionListener(e -> {
            // Aquí se conectaría con tu clase de gestión de ventas
            // Por ejemplo: new VentaMenu().menuNuevaVenta();
            outputArea.setText("Función para registrar nueva venta");
        });
        
        viewSalesButton.addActionListener(e -> {
            outputArea.setText("Función para ver ventas");
        });
        
        reportButton.addActionListener(e -> {
            outputArea.setText("Función para generar reporte de ventas");
        });
        
        return panel;
    }
    
    private static JPanel createInventoryManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Gestión de Inventario", SwingConstants.CENTER), BorderLayout.NORTH);
        
        JButton addButton = new JButton("Agregar Producto");
        JButton editButton = new JButton("Editar Producto");
        JButton deleteButton = new JButton("Eliminar Producto");
        JButton listButton = new JButton("Listar Inventario");
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(listButton);
        
        JTextArea outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        
        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Conectar con la clase existente
        addButton.addActionListener(e -> {
            // Aquí se conectaría con tu clase de gestión de inventario
            // Por ejemplo: new InventarioMenu().menuAgregarProducto();
            outputArea.setText("Función para agregar producto al inventario");
        });
        
        editButton.addActionListener(e -> {
            outputArea.setText("Función para editar producto del inventario");
        });
        
        deleteButton.addActionListener(e -> {
            outputArea.setText("Función para eliminar producto del inventario");
        });
        
        listButton.addActionListener(e -> {
            outputArea.setText("Función para listar el inventario");
        });
        
        return panel;
    }
    
    private static JPanel createMenuViewPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Menú del Restaurante", SwingConstants.CENTER), BorderLayout.NORTH);
        
        // Simulación de menú para cliente
        String[] categories = {"Entradas", "Platos Principales", "Postres", "Bebidas"};
        
        JComboBox<String> categoryCombo = new JComboBox<>(categories);
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Categoría:"));
        topPanel.add(categoryCombo);
        
        JTextArea menuArea = new JTextArea(20, 40);
        menuArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(menuArea);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Evento para cambiar entre categorías
        categoryCombo.addActionListener(e -> {
            String selected = (String) categoryCombo.getSelectedItem();
            switch (selected) {
                case "Entradas":
                    menuArea.setText("ENTRADAS:\n\n1. Ensalada César - $6.99\n2. Palitos de Mozzarella - $5.99\n3. Sopa del Día - $4.99");
                    break;
                case "Platos Principales":
                    menuArea.setText("PLATOS PRINCIPALES:\n\n1. Bistec a la Parrilla - $15.99\n2. Pasta Alfredo - $12.99\n3. Pollo al Horno - $14.99");
                    break;
                case "Postres":
                    menuArea.setText("POSTRES:\n\n1. Tarta de Chocolate - $5.99\n2. Helado de Vainilla - $4.99\n3. Flan - $5.50");
                    break;
                case "Bebidas":
                    menuArea.setText("BEBIDAS:\n\n1. Refresco - $2.50\n2. Café - $3.00\n3. Jugo Natural - $3.50");
                    break;
            }
        });
        
        // Inicializar con la primera categoría
        categoryCombo.setSelectedIndex(0);
        
        return panel;
    }
    
    private static JPanel createMakeReservationPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Hacer Reserva", SwingConstants.CENTER), BorderLayout.NORTH);
        
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        formPanel.add(new JLabel("Nombre:"));
        JTextField nameField = new JTextField();
        formPanel.add(nameField);
        
        formPanel.add(new JLabel("Teléfono:"));
        JTextField phoneField = new JTextField();
        formPanel.add(phoneField);
        
        formPanel.add(new JLabel("Fecha (DD/MM/AAAA):"));
        JTextField dateField = new JTextField();
        formPanel.add(dateField);
        
        formPanel.add(new JLabel("Hora (HH:MM):"));
        JTextField timeField = new JTextField();
        formPanel.add(timeField);
        
        formPanel.add(new JLabel("Número de Personas:"));
        JTextField peopleField = new JTextField();
        formPanel.add(peopleField);
        
        JButton reserveButton = new JButton("Hacer Reserva");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(reserveButton);
        
        JTextArea statusArea = new JTextArea(5, 30);
        statusArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);
        
        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.SOUTH);
        
        reserveButton.addActionListener(e -> {
            // Validar los campos
            if (nameField.getText().isEmpty() || phoneField.getText().isEmpty() || 
                dateField.getText().isEmpty() || timeField.getText().isEmpty() || 
                peopleField.getText().isEmpty()) {
                statusArea.setText("Error: Todos los campos son obligatorios.");
                return;
            }
            
            // Aquí conectarías con tu clase de reservas
            // Por ejemplo: new ClienteMenu().hacerReserva(nameField.getText(), ...);
            statusArea.setText("Reserva enviada correctamente para " + nameField.getText() + 
                              " el " + dateField.getText() + " a las " + timeField.getText() + 
                              " para " + peopleField.getText() + " personas.");
        });
        
        return panel;
    }
}