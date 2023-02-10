Feature: Scoring a game of tennis

    Call out the official score for the points scored in a game of tennis

    Rule: Individual scores are called out when either player leads

        Scenario Outline: the one where either player leads
            Given the points scored are
                | player one   | player two   |
                | <player_one> | <player_two> |
            When the score is called out
            Then the score should be "<score>"

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

    Rule: Scores end with "all" when players points are equal but less then three

        Scenario Outline: the one where the score is "score-all"
            Given the points scored are
                | player one | player two |
                | <points>   | <points>   |
            When the score is called out
            Then the score should be "<score>"

            Examples:
                | points | score       |
                | 0      | love-all    |
                | 1      | fifteen-all |
                | 2      | thirty-all  |

    Rule: Score is deuce when players have the same score and three or more points

        Scenario Outline: the one where the score is "deuce"
            Given the points scored are
                | player one | player two |
                | <points>   | <points>   |
            When the score is called out
            Then the score should be "deuce"

            Examples:
                | points |
                | 3      |
                | 4      |

    Rule: The player who has one point more when both players have at least three points has the advantage

        Scenario Outline: the one where a player has the advantage
            Given the points scored are
                | player one   | player two   |
                | <player_one> | <player_two> |
            When the score is called out
            Then the advantage is for "<leader>"

            Examples:
                | player_one | player_two | leader     |
                | 4          | 5          | player two |
                | 6          | 5          | player one |

    Rule: The player who scored at least three points and has two points over the other player wins

        Scenario Outline: the one where a player wins
            Given the points scored are
                | player one   | player two   |
                | <player_one> | <player_two> |
            When the score is called out
            Then the winner is "<winner>"

            Examples:
                | player_one | player_two | winner     |
                | 4          | 0          | player one |
                | 0          | 4          | player two |
                | 2          | 4          | player two |
                | 5          | 3          | player one |
