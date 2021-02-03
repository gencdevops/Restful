package org.javaturk.wap.mvc.login.util;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * @author akin
 *
 */
public class WeldUtil {
	public static final WeldUtil INSTANCE = new WeldUtil();

	private final Weld weld;
	private final WeldContainer container;

	private WeldUtil() {
		this.weld = new Weld();
		this.container = weld.initialize();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				weld.shutdown();
			}
		});
	}

	public <T> T getBean(Class<T> type) {
		return container.instance().select(type).get();
	}
}
