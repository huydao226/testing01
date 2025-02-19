package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        this.page = page;
    }

    public void inputUserCredential(String userName, String password) {
        inputTextBoxByName("Tài Khoản", userName);
        inputTextBoxByName("Mật Khẩu", password);

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ĐĂNG NHẬP")).click();
        page.waitForSelector("#homeTool");
    }
}
