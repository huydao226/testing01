package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class BasePage {
    protected Page page;

    void inputTextBoxByName(String textBoxName, String input){
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(textBoxName)).fill(input);
    }

}
