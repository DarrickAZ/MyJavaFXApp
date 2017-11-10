package cn.collabtech.javafx.controller;

import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController extends BaseController{
	/**
	* Logger for this class
	*/
	private static final Logger logger = Logger.getLogger(LoginController.class);

	
	@FXML
	private Button cancelButton;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
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
	

}
