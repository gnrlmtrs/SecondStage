package page;

import elements.BaseElement;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractPage {

    protected BaseElement element;
    protected String name;

    public boolean pageIsDisplayed() {
        return element.isDisplayed();
    }
}
