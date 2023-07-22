package uk.to.and1558.Events;

import java.util.ArrayList;

public class Event {

	public Event call() {
		final ArrayList<EventData> dataList = EventManager.get(this.getClass());
		if (dataList != null) {
			for (final EventData data : dataList) {
				try {
					data.target.invoke(data.source, this);
				}
				catch (Exception e) {
					// ignore
				}
			}
		}
		return this;
	}
}
