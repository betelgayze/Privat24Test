import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class PrivatTest {

    @Test
    public void transactionTest () {
        WebDriverManager.chromedriver().setup();
        Selenide.open("https://next.privat24.ua/money-transfer/card");
        //card of source(names should go last)
        Selenide.$("[data-qa-node='numberdebitSource']").sendKeys("4552331448138217");
        Selenide.$("[data-qa-node='expiredebitSource']").sendKeys("0524");
        Selenide.$("[data-qa-node='cvvdebitSource']").sendKeys("926");
        //name of source
        Selenide.$("[data-qa-node='firstNamedebitSource']").sendKeys("NAMEONE");
        Selenide.$("[data-qa-node='lastNamedebitSource']").sendKeys("SURONE");
        // card of rec
        Selenide.$("[data-qa-node='numberreceiver']").sendKeys("4004159115449003");
        //name of rec
        Selenide.$("[data-qa-node='firstNamereceiver']").sendKeys("NAMETWO");
        Selenide.$("[data-qa-node='lastNamereceiver']").sendKeys("SURTWO");
        //sum
        Selenide.$("[data-qa-node='amount']").sendKeys("330");
        //execute
        Selenide.$("[data-qa-node='amount']").sendKeys(Keys.ENTER);


        //check
        Selenide.$("[data-qa-node='payer-card']").shouldHave(Condition.text("4552 3314 4813 8217"));
        Selenide.$("[data-qa-node='payer-amount']").shouldHave(Condition.text("330 UAH"));
        Selenide.$("[data-qa-node='payer-currency']").shouldHave(Condition.text("103.32 UAH"));
        Selenide.$("[data-qa-node='receiver-name']").shouldHave(Condition.text("NAMETWO SURTWO"));
        Selenide.$("[data-qa-node='receiver-card']").shouldHave(Condition.text("4004 1591 1544 9003"));
        Selenide.$("[data-qa-node='receiver-amount']").shouldHave(Condition.text("330 UAH"));
        Selenide.$("[data-qa-node='receiver-currency']").shouldHave(Condition.text("0 UAH"));
        Selenide.$("[data-qa-node='total']").shouldHave(Condition.text("433.32 UAH"));
    }
}
