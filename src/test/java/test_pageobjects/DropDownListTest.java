package test_pageobjects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.page.DropDownListPage;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class DropDownListTest extends BaseTest {
    private final int questionIndex;
    private final String expectedQuestion;
    private final String expectedAnswer;

    public DropDownListTest(int questionIndex, String expectedQuestion, String expectedAnswer) {
        this.questionIndex = questionIndex;
        this.expectedQuestion = expectedQuestion;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters(name = "Вопрос номер {0}")
    public static Collection<Object[]> dropDownData() {
        return Arrays.stream(DropDownListPage.QUESTIONS)
                .map(question -> new Object[]{
                        Arrays.asList(DropDownListPage.QUESTIONS).indexOf(question),
                        question, // Текст вопроса
                        DropDownListPage.EXPECTED_ANSWER[Arrays.asList(DropDownListPage.QUESTIONS).indexOf(question)]
                })
                .collect(Collectors.toList());
    }

    @Test // Тест на соответствие текста вопросов и ответов
    public void testFAQAnswerAndQuestion() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        DropDownListPage dropDownListPage = new DropDownListPage();
        assertEquals(expectedQuestion, dropDownListPage.getTextQuestion(questionIndex));
        dropDownListPage.clickButtonQuestion(questionIndex);
        assertEquals(expectedAnswer, dropDownListPage.getAnswerText(questionIndex));
    }


}


