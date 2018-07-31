package com.example.sprachmensch.jokeslib;

import java.util.Random;

public class JokeProvider {

    /*
       all jokes from reddit.com/r/AntiJoke
    * */
    private static final String[] jokes = {
            "Yo mama is so fat - That your father no longer finds her sexually attractive, and its ruining their marriage...",
            "What do you call a nun in a wheelchair? Sister",
            "Man walks into a bar  - he is an alcoholic and he hurts his family.",
            "I'll tell you what - What",
            "Why Can\'t Dinosaurs Clap? Because they\'re dead.",
            "\"Knock Knock\" \n \"Who's there?\"\n \"This is UPS, I have a package you need to sign for\" \n \"Thanks UPS man.\"",
            "What has five toes but isn't your foot? My foot",
            "What's brown and sticky? A stick.",
            "What can be shot 100s of times but never dies? A gun",
            "What do you get when you cross a goat with an alligator? A P.E.T.A lawsuit for unethical genetic experimentation.",
            "What did the Farmer say when he lost his truck? Where's my truck?"
    };

    public static String getJoke() {
        Random rnd = new Random();

        return jokes[rnd.nextInt(jokes.length)];
    }
}

