package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class SearchPage {

    private SelenideElement searchInput = Selenide.$(By.xpath("//input[@placeholder='Where are you going?']"));
    private SelenideElement autocompleteFirstResult = Selenide.$(By.xpath("//ul[@data-testid = 'autocomplete-results']//li[1]"));
    private SelenideElement searchButton = Selenide.$(By.xpath("//button[@type='submit' and span='Search']"));
    private SelenideElement firstCardTitle = Selenide.$(By.xpath("//div[@data-testid = 'property-card'][1]//div[@data-testid = 'title']"));
    private SelenideElement firstCardRating = Selenide.$(By.xpath("//div[@data-testid = 'property-card'][1]//div[@data-testid = 'review-score']//div"));

    public SearchPage() {
    }

    public SearchPage openSearchPage() {
        Selenide.open("https://www.booking.com/searchresults.en-gb.html");
        return this;
    }

    public SearchPage enterHotelTitle(String hotelTitle) {
        this.searchInput.shouldBe(new Condition[]{Condition.visible}).sendKeys(new CharSequence[]{hotelTitle});
        return this;
    }

    public SearchPage clickOnAutocompleteResult() {
        this.autocompleteFirstResult.shouldBe(new Condition[]{Condition.visible}).click();
        return this;
    }

    public SearchPage clickSearchButton() {
        this.searchButton.shouldBe(new Condition[]{Condition.visible}).click();
        return this;
    }

    public String getResultHotelTitle() {
        return this.firstCardTitle.shouldBe(new Condition[]{Condition.visible}).getText();
    }

    public String getResultRating() {
        return this.firstCardRating.shouldBe(new Condition[]{Condition.visible}).getText();
    }
}
