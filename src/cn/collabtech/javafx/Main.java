package cn.collabtech.javafx;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import cn.collabtech.javafx.common.AppConstants;
import cn.collabtech.javafx.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Main.class);

	private static Stage primaryStage;

	@Override
	public void start(Stage stage) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("start(Stage) - start");
		}
		URL url = Thread.currentThread().getContextClassLoader().getResource("resource/fxml/login.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(url);
		Parent root = fxmlLoader.load();
		// create scene
		Scene scene = new Scene(root, AppConstants.PRIMARY_STAGE_WIDTH,AppConstants.PRIMARY_STAGE_HEIGTH);
		// 设置窗口title
		stage.setTitle(AppConstants.PRIMARYSTAGE_TITLE);

		// 禁用窗口缩放
		// stage.setResizable(false);

		// 设置窗口的图标.
		stage.getIcons().add(new Image(AppConstants.APP_LOGO_PATH));

		stage.setScene(scene);
		// show stage
		stage.show();

		this.primaryStage = stage;

		LoginController loginController = fxmlLoader.getController();
		loginController.setPrimaryStage(stage);

		if (logger.isInfoEnabled()) {
			logger.info("start(Stage) - end");
		}
	}

	public static void main(String[] args) {

		PropertyConfigurator
				.configure(Thread.currentThread().getContextClassLoader().getResource(AppConstants.LOG4J_PATH));
		// PropertyConfigurator.configure(
		// Thread.currentThread().getContextClassLoader().getResource("cn/collabtech/javafx/resource/config/log4j.properties"));
		// 运行主程序入口

		try {
			logger.info("main(String[]) - start");
			int i = 0 / 1;
			launch(args);
			logger.info("start(String[]) - end");
		} catch (Exception e) {
			logger.error(e + ">>>" + e.getCause());
		}

	}
}
