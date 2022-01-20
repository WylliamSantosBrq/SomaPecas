package com.brq.interfaces.log;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;

import org.sikuli.script.Screen;

import com.brq.util.FileHelper;

import cucumber.api.Scenario;

public interface DesktopPrint {

	Screen s = new Screen();

	static String tirarPrintDesktop(Scenario cenario) {
		try {
			Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(rec);
			String nome = LocalDateTime.now().toString().replace("-", "_").replace(":", "_").replace("\\.", "_")
					.replace("T", "_");
			String pastaPrints = cenario.isFailed() ? "Prints_Erro" : "Prints_Sucesso";
			String caminhoRelativo = "Evidencias" +File.separator + pastaPrints + File.separator;
			String caminhoAbsoluto = FileHelper.projectFolder(caminhoRelativo);
			s.capture().save(caminhoAbsoluto);
//			ImageIO.write(image, "png", new File(caminhoRelativo));
			return caminhoRelativo;

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
