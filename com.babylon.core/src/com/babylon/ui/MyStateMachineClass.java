package com.babylon.ui;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 23.04.14
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class MyStateMachineClass {
    private enum GameState {
        StartScreen, AskQuestion, CongratulateUser, ScoldUser
    }
    private GameState m_CurrentGameState;
    //---------------------------------------------------------------------
    //Конечный автомат, воздействующий на пользовательский интерфейс
    //и управляющий переходами приложения в другие состояния в соответствии
    //c текущим режимом работы пользователя
    //---------------------------------------------------------------------
    private void StateChangeForGame(GameState newGameUIState) throws Exception {
        //Определить, в какое состояние переходит приложение
        switch(newGameUIState) {
            case StartScreen:
                //Если переход в данное состояние осуществляется из состояния,
                //для которого это запрещено, возбудить исключение
                if ((m_CurrentGameState != GameState.CongratulateUser) && (m_CurrentGameState != GameState.ScoldUser)) {
                    throw new Exception("Запрещённый переход!");
                }
                //ЧТО СДЕЛАТЬ: Поместите сюда код, выполняющий следующие операции:
                // 1. Скрытие (Hide), отображение (Show) и перемещение (Move)
                // элементов управления пользовательского интерфейса
                // 2. Настройка переменных/состояния игры, соответствующих
                // данному режиму работы
                //
                // SetUpGameStateForStartScreen();
                break;
            case AskQuestion:
                //Если переход в данное состояние осуществляется из состояния,
                //для которого это запрещено, возбудить исключение
                if ((m_CurrentGameState != GameState.StartScreen)
                        && (m_CurrentGameState != GameState.CongratulateUser)
                        && (m_CurrentGameState !=GameState.ScoldUser)) {
                    throw new Exception("Запрещённый переход!");
                }
                //ЧТО СДЕЛАТЬ: Поместите сюда код, выполняющий следующие операции:
                // 1. Скрытие (Hide), отображение (Show) и перемещение (Move)
                // элементов управления пользовательского интерфейса
                // 2. Настройка переменных/состояния игры, соответствующих
                // данному режиму работы
                //
                // SetUpGameStateForAskQuestion();
                break;
            case CongratulateUser:
                //Если переход в данное состояние осуществляется из состояния,
                //для которого это запрещено, возбудить исключение
                if (m_CurrentGameState != GameState.AskQuestion) {
                    throw new Exception("Запрещённый переход!");
                }
                //ЧТО СДЕЛАТЬ: Поместите сюда код, выполняющий следующие операции:
                // 1. Скрытие (Hide), отображение (Show) и перемещение (Move)
                // элементов управления пользовательского интерфейса
                // 2. Настройка переменных/состояния игры, соответствующих
                // данному режиму работы
                //
                // SetUpGameStateForCongratulateUser();
                break;
            case ScoldUser:
                //Если переход в данное состояние осуществляется из состояния,
                //для которого это запрещено, возбудить исключение
                if (m_CurrentGameState != GameState.AskQuestion) {
                    throw new Exception("Запрещённый переход!");
                }
                //ЧТО СДЕЛАТЬ: Поместите сюда код, выполняющий следующие операции:
                // 1. Скрытие (Hide), отображение (Show) и перемещение (Move)
                // элементов управления пользовательского интерфейса
                // 2. Настройка переменных/состояния игры, соответствующих
                // данному режиму работы
                //
                // SetUpGameStateForScoldUser();
                break;
            default:
                throw new Exception("Неизвестное состояние!");
        }
        //Сохранить запрошенное новое состояние в качестве текущего
        m_CurrentGameState = newGameUIState;
    }
}
