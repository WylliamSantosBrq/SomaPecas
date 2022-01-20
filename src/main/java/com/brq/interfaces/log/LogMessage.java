package com.brq.interfaces.log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.brq.util.StringHelper;

/**
 * Builder de mensagens para o log.
 * 
 * @author ymnoda
 *
 */
public class LogMessage implements Loggable {

	private LogMessage() {

	}

	public static class Builder {

		private String message = "";
		private String stackTrace = "";
		private String element = "";

		public String log() {
			BRQLogger.info(message);
			BRQLogger.info("Elemento: [%s]", element);
			BRQLogger.info(stackTrace);
			return message;
		}

		public String error() {
			BRQLogger.error(message);
			BRQLogger.error("Elemento: [%s]", element);
			BRQLogger.error(stackTrace);
			return message;
		}

		public Builder withMessage(String message, Object... args) {
			this.message = String.format(message, args);
			return this;
		}

		public Builder withStackTrace(Exception e) {
			this.stackTrace = StringHelper.exceptionStackTrace(e);
			return this;
		}

		public Builder withStackTrace(Throwable t) {
			this.stackTrace = StringHelper.throwableStackTrace(t);
			return this;
		}

		public Builder withElement(WebElement elemento) {
			this.element = elemento.toString();
			return this;
		}

		public Builder withElement(By elemento) {
			this.element = elemento.toString();
			return this;
		}
	}

	public static Builder builder() {
		return new Builder();
	}

}
