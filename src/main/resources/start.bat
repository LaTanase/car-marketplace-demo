echo Running Car Marketplace Demo Application

java -cp car-marketplace-demo-app.jar -Xdebug -Xrunjdwp:transport=dt_socket,address=5006,server=y,suspend=n -Dconfig.location=./application.properties -Dloader.path=./lib org.springframework.boot.loader.PropertiesLauncher