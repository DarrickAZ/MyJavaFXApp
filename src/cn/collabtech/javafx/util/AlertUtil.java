package cn.collabtech.javafx.util;

import java.util.Optional;

import cn.collabtech.javafx.common.AppConstants;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class AlertUtil {
	/**
	 * 信息提示框
	 * 
	 * @param message
	 */
	public static void showInfoAlert(String message, Stage stage) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(AppConstants.PRIMARYSTAGE_TITLE);
		// 设置alert弹出框的图标
		alert.initOwner(stage);
		alert.setContentText(message);
		alert.show();
	}

	/**
	 * 等待信息提示框
	 * 
	 * @param message
	 */
	public static void showAndWaitInfoAlert(String message, Stage stage) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText(message);
		alert.showAndWait();
	}

	/**
	 * 注意提示框
	 * 
	 * @param message
	 */
	public static void showWarnAlert(String message, Stage stage) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setContentText(message);
		alert.show();
	}

	/**
	 * 异常提示框
	 * 
	 * @param message
	 */
	public static void showErrorAlert(String message, Stage stage) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(message);
		alert.show();
	}

	/**
	 * 确定提示框
	 * 
	 * @param message
	 */
	public static boolean showConfirmAlert(String message, Stage stage) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setContentText(message);
		Optional<ButtonType> optional = alert.showAndWait();
		if (ButtonType.OK == optional.get()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 系统窗口关闭确认框
	 * 
	 * @param message
	 */
	public static boolean showPlatformCloseConfirmAlert(String message, Stage stage) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(AppConstants.CLOSE_PLATFORM_CONFIRM_MSG);
		alert.initOwner(stage);
		alert.setContentText(message);
		Optional<ButtonType> optional = alert.showAndWait();
		if (ButtonType.OK == optional.get()) {
			// 如果用户点击确定则直接退出当前程序。
			Platform.exit();
			return true;
		} else {
			stage.show();
			return false;
		}
	}

}
