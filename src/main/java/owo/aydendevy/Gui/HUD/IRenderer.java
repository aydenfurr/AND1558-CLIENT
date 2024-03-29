package owo.aydendevy.Gui.HUD;

public interface IRenderer extends IRenderConfig{
	int getWidth();
	int getHeight();
	void render(ScreenPosition pos);
	default void renderDummy(ScreenPosition pos) {
		render(pos);
	}
	
	public default boolean isEnabled() {
		return true;
	}
}
