package net.minimal;

/**
 * @author Nadir Román Guerrero
 */
public interface AbstractFieldController
{
	public void setPlaceholder(final String text);
	public void onUserClick();
	public boolean isPlaceholderActive();
}
