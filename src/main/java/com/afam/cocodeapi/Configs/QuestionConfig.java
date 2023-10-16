package com.afam.cocodeapi.Configs;

import com.afam.cocodeapi.Enums.QuestionDifficulty;
import com.afam.cocodeapi.Models.QuestionModel;
import com.afam.cocodeapi.Repositories.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class QuestionConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            QuestionRepository questionRepository
    ) {
        return args -> {
            QuestionModel Two_Sum = new QuestionModel("Two Sum",
                    "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n" +
                            "\n" +
                            "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n" +
                            "\n" +
                            "You can return the answer in any order.",
                    "Example 1:\n" +
                            "\n" +
                            "Input: nums = [2,7,11,15], target = 9\n" +
                            "Output: [0,1]\n" +
                            "Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].\n" +
                            "Example 2:\n" +
                            "\n" +
                            "Input: nums = [3,2,4], target = 6\n" +
                            "Output: [1,2]\n" +
                            "Example 3:\n" +
                            "\n" +
                            "Input: nums = [3,3], target = 6\n" +
                            "Output: [0,1]",
                    "2 <= nums.length <= 104\n" +
                            "-109 <= nums[i] <= 109\n" +
                            "-109 <= target <= 109",
                    QuestionDifficulty.EASY);

            QuestionModel Contains_Duplicate = new QuestionModel("Contains Duplicate",
                    "Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.",
                    "Example 1:\n" +
                            "\n" +
                            "Input: nums = [1,2,3,1]\n" +
                            "Output: true\n" +
                            "Example 2:\n" +
                            "\n" +
                            "Input: nums = [1,2,3,4]\n" +
                            "Output: false\n" +
                            "Example 3:\n" +
                            "\n" +
                            "Input: nums = [1,1,1,3,3,4,3,2,4,2]\n" +
                            "Output: true",
                    "1 <= nums.length <= 105\n" +
                            "-109 <= nums[i] <= 109",
                    QuestionDifficulty.EASY);

            questionRepository.saveAll(
                    List.of(Two_Sum, Contains_Duplicate)

            );
        };
    }
}
