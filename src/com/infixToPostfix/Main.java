package com.infixToPostfix;

import java.util.*;

public class Main {

  // Fungsi untuk menentukan prioritas operator
  public static int priority(char op) {
    if (op == '+' || op == '-')
      return 1;
    else if (op == '*' || op == '/')
      return 2;
    else if (op == '^')
      return 3;
    else
      return 0;
  }

  // Fungsi untuk mengubah notasi infix menjadi postfix
  public static String infixToPostfix(String infix) {
    // Inisialisasi stack untuk operator
    Stack<Character> operatorStack = new Stack<>();

    // Inisialisasi deque untuk output postfix
    Deque<Character> postfixDeque = new ArrayDeque<>();

    // Loop untuk memproses setiap karakter dalam notasi infix
    for (int i = 0; i < infix.length(); i++) {
      char c = infix.charAt(i);

      // Jika karakter adalah operand, tambahkan ke deque postfix
      if (Character.isLetterOrDigit(c)) {
        postfixDeque.add(c);
      }

      // Jika karakter adalah kurung buka, tambahkan ke stack operator
      else if (c == '(') {
        operatorStack.push(c);
      }

      // Jika karakter adalah kurung tutup, pop stack operator sampai menemukan kurung
      // buka
      else if (c == ')') {
        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
          postfixDeque.add(operatorStack.pop());
        }
        if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
          return "Not valid";
        } else {
          operatorStack.pop();
        }
      }

      // Jika karakter adalah operator, pop stack operator sampai menemukan operator
      // dengan prioritas yang lebih rendah atau stack kosong
      else {
        while (!operatorStack.isEmpty() && priority(c) <= priority(operatorStack.peek())) {
          postfixDeque.add(operatorStack.pop());
        }
        operatorStack.push(c);
      }
    }

    // Pop sisa operator di stack dan tambahkan ke deque postfix
    while (!operatorStack.isEmpty()) {
      postfixDeque.add(operatorStack.pop());
    }

    // Konversi deque postfix menjadi string
    StringBuilder postfix = new StringBuilder();
    for (char c : postfixDeque) {
      postfix.append(c);
    }

    return postfix.toString();
  }

  public static void main(String[] args) {
    String infix = "a+b*(c^d-e)^(f+g*h)-i";
    String postfix = infixToPostfix(infix);
    System.out.println(postfix);
  }
}
