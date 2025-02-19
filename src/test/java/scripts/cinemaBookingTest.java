package scripts;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class cinemaBookingTest extends BaseTest{


    @Test
    void testBookingCinema() {

        HomePage homePage = new HomePage(page);
        LoginPage loginPage = new LoginPage(page);

        homePage.clickLoginButton();
        loginPage.inputUserCredential("huydao226", "asdEDZ12#");

        //Actions action = new Action(driver)
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("HÀNH TRÌNH CỦA MOANA")).hover();
        page.getByText("MUA VÉ", new Page.GetByTextOptions().setExact(true)).click();
        page.getByText("18-08-2024").click();

//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("51").setExact(true)).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ĐẶT VÉ")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Đồng ý")).click();

        page.getByAltText("Avatar").click();
        Locator giaVe = page.locator(".MuiGrid-grid-md-6").last().getByText("Giá vé");
        assertThat(giaVe).containsText("144000");
    }

    @Test
    void testProfileCinema() {
        page.getByText("Đăng Nhập").click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Tài Khoản")).fill("huydao226");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Mật Khẩu")).fill("asdEDZ12#");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ĐĂNG NHẬP")).click();
        page.waitForSelector("#homeTool");

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("HÀNH TRÌNH CỦA MOANA")).hover();
        page.getByText("MUA VÉ", new Page.GetByTextOptions().setExact(true)).click();
        page.getByText("18-08-2024").click();

//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("51").setExact(true)).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("ĐẶT VÉ")).click();
//        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Đồng ý")).click();

        page.getByAltText("Avatar").click();
        Locator giaVe = page.locator(".MuiGrid-grid-md-6").last().getByText("Giá vé");
        assertThat(giaVe).containsText("144000");
    }
}
