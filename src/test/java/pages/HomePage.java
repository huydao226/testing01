package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void clickLoginButton(){
        page.getByText("Đăng Nhập").click();
    }

}
