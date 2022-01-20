package com.brq.interfaces.dados;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

import org.reflections.Reflections;

import com.brq.erros.ErroAutomacao;
import com.brq.interfaces.log.BRQLogger;
import com.brq.interfaces.log.Loggable;

public class DadosMaster implements Loggable {

	private DadosMaster() {

	}

	public static void resetAll() throws NoSuchMethodException, SecurityException {
		BRQLogger.info("Resetar todos os com.brq.dados.");

		Reflections reflections = new Reflections("com.brq.dados");
		Set<Class<? extends Resetable>> classes = reflections.getSubTypesOf(Resetable.class);

		Resetable target = (Resetable) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				new Class[] { Resetable.class }, (Object proxy, Method method, Object[] arguments) -> null);

		for (Class<? extends Resetable> classe : classes) {
			Method reset = classe.getMethod("reset");

			try {
				reset.setAccessible(true);

//				MethodHandles.lookup()
//				.in(reset.getDeclaringClass())
//				.unreflectSpecial(reset,reset.getDeclaringClass())
//				.bindTo(target)
//				.invokeWithArguments();
				reset.invoke(target);

			} catch (IllegalAccessException e) {
				throw new ErroAutomacao(e, "Acesso ilegal.");
			} catch (IllegalArgumentException e) {
				throw new ErroAutomacao(e, "Argumento ilegal no método.");
			} catch (InvocationTargetException e) {
				throw new ErroAutomacao(e, "Não foi possível invocar o método.");
//			} catch (NoSuchMethodException e) {
//				throw new ErroAutomacao(e, "Não foi possível encontrar o método.");
			} catch (SecurityException e) {
				throw new ErroAutomacao(e, "Não foi acessar o método.");
			} finally {
				reset.setAccessible(false);
			}

		}
	}

}
