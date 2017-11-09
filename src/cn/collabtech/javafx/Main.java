package cn.collabtech.javafx;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(Main.class);

	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("start(Stage) - start");
		}
		
		this.primaryStage = primaryStage;

		System.out.println("xxxxxxxxxxxxxxxxx");
		
		if (logger.isInfoEnabled()) {
			logger.info("start(Stage) - end");
		}
		int i = 1 / 0;
	}

	public static void main(String[] args) {

		PropertyConfigurator.configure(
				Thread.currentThread().getContextClassLoader().getResource("resource/config/log4j.properties"));
		// PropertyConfigurator.configure(
		// Thread.currentThread().getContextClassLoader().getResource("cn/collabtech/javafx/resource/config/log4j.properties"));

		// 运行主程序入口

		try {
			logger.info("main(String[]) - start");
			int i = 0 / 1;
			launch(args);
			logger.info("start(String[]) - end");
		} catch (Exception e) {
			logger.error(e);
		}

	}
}
