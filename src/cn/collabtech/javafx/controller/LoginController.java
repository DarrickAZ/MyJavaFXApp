package cn.collabtech.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import cn.collabtech.javafx.common.AppConstants;
import cn.collabtech.javafx.util.AlertUtil;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@FXML
	private TextField userName;

	@FXML
	private TextField passWord;

	@FXML
	private Button cancelButton;

	@FXML
	private Button loginButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// userName.setOnKeyPressed(new EventHandler<KeyEvent>() {
		// @Override
		// public void handle(KeyEvent event) {
		// if (event.getCode() == KeyCode.ENTER) {
		// System.out.println("userName ");
		// }
		// }
		// });

		// 监听Button回车事件
		loginButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					// 执行登录操作
					loginButton.fire();
				}
			}
		});

		// 监听password回车事件
		passWord.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					// 执行登录操作
					loginButton.fire();
				}
			}
		});

		// 监听cancel事件
		cancelButton.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				// 监听用户取消事件，并退出当前系统。
				Platform.exit();
			}
		});

	}

	public void loginApp(ActionEvent event) {
		try {
			//int i = 0 / 1;
			//int i1 = 1 / 0;
			String name = userName.getText();
			String pwd = passWord.getText();
			if (logger.isInfoEnabled()) {
				logger.info("loginApp(ActionEvent) - String name=" + name);
			}
			if (logger.isInfoEnabled()) {
				logger.info("loginApp(ActionEvent) - String pwd=" + pwd);
			}

			if ("".equals(name)) {
				// 弹出alert窗口提示信息
				AlertUtil.showInfoAlert("用户名不能为空!", getPrimaryStage());
				return;
			}
			if ("".equals(pwd)) {
				// 弹出alert窗口提示信息
				AlertUtil.showInfoAlert("密码不能为空!", getPrimaryStage());
				return;
			}

			// TODO:验证密码合法性
			if ("admin".equals(name) && "admin".equals(pwd)) {
				// TODO:密码正确,跳转到对应页面
				// URL url =
				// Thread.currentThread().getContextClassLoader().getResource("resource/fxml/index.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(
						getClass().getClassLoader().getResource(AppConstants.INDEX_FXML));
				try {
					Parent root = fxmlLoader.load();
					Scene scene = new Scene(root, AppConstants.PRIMARY_STAGE_WIDTH, AppConstants.PRIMARY_STAGE_HEIGTH);
					getPrimaryStage().setScene(scene);
					getPrimaryStage().show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				// 密码错误，给予提示。
				AlertUtil.showInfoAlert("用户名或密码错误，请重新输入。", getPrimaryStage());
			}
		} catch (Exception e) {
			logger.error(e);
		}

	}

	public void cancelButtonApp(ActionEvent event) {
		if (logger.isInfoEnabled()) {
			logger.info("cancelButtonApp(ActionEvent) - start");
		}

		Platform.exit();

		if (logger.isInfoEnabled()) {
			logger.info("cancelButtonApp(ActionEvent) - end");
		}
	}

	public Button getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(Button cancelButton) {
		this.cancelButton = cancelButton;
	}

	public Button getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(Button loginButton) {
		this.loginButton = loginButton;
	}

}
