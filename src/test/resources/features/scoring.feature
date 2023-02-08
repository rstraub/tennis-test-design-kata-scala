Feature: Scoring a game of tennis

    Rule: Individual scores are called out when either player leads

        Scenario Outline: the one where either player leads
            Given the points scored are
                | player one   | player two   |
                | <player_one> | <player_two> |
            When the score is called out
            Then it is "<score>"

            Examples:
                | player_one | player_two | score          |
                | 1          | 0          | fifteen-love   |
                | 2          | 0          | thirty-love    |
                | 3          | 0          | forty-love     |
                | 0          | 1          | love-fifteen   |
                | 0          | 2          | love-thirty    |
                | 0          | 3          | love-forty     |
                | 1          | 2          | fifteen-thirty |
                | 1          | 3          | fifteen-forty  |
                | 2          | 3          | thirty-forty   |
                | 3          | 2          | forty-thirty   |
                | 3          | 1          | forty-fifteen  |
                | 2          | 1          | thirty-fifteen |
