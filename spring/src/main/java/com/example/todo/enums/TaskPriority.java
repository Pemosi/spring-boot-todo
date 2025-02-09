package com.example.todo.enums;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum TaskPriority {
  LOW(0, "低"), MEDIUM(1, "中"), HIGH(2, "高");

  private final int value;
  private final String label;

  TaskPriority(int value, String label) {
    this.value = value;
    this.label = label;
  }

  /**
   * 値（value）から、TaskPriority を取得する
   *
   * @param value 優先度の値
   * @return TaskPriority
   */
  public static TaskPriority fromValue(int value) {
    // 処理の順番は以下。
    // 1. TaskPriority.values() で、TaskPriorityの全ての値を取得し、Streamに変換する。
    // 2. filter() で、引数の値と一致するTaskPriorityを取得する。
    // 3. findFirst() で、取得したTaskPriorityの中で最初の要素を取得する。
    // 4. orElseThrow() で、TaskPriorityが取得できなかった場合に例外をスローする。取得できた場合はその値を返す。
    return Arrays.stream(TaskPriority.values()).filter(priority -> priority.getValue() == value)
        .findFirst().orElseThrow(() -> new IllegalArgumentException("Unexpected value: " + value));
  }
}
