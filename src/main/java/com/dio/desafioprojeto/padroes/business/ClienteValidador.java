package com.dio.desafioprojeto.padroes.business;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import com.dio.desafioprojeto.padroes.model.Cliente;

public class ClienteValidador {

  private static ClienteValidador instance;

  private ClienteValidador() {
  }

  public static ClienteValidador getInstance() {
    if (instance == null)
      instance = new ClienteValidador();
    return instance;
  }

  public static boolean isValido(Cliente cliente) {
    if (!isCpfValido(cliente.getCpf()))
      return false;

    if (!isEmailValido(cliente.getEmail()))
      return false;

    if (!isTelefoneValido(cliente.getTelefone()))
      return false;

    return true;
  }

  private static boolean isCpfValido(String cpf) {
    return Pattern.matches("[\\d]{11}", cpf);
  }

  private static boolean isEmailValido(String email) {
    String regex = 
        "[A-Za-z0-9_-[.]]{4,64}@[A-Za-z0-9]{1,64}.([A-Za-z]{2,3}|[A-Za-z]{2,3}.[A-Za-z]{2,3})";
    return Pattern.matches(regex, email);
  }

  private static boolean isTelefoneValido(String telefone) {
    if (Pattern.matches("[\\d]{10,11}", telefone))
      return isDddValido(telefone);
    return false;
  }

  private static boolean isDddValido(String telefone) {
    String[] DDDs = { "11", "12", "13", "14", "15", "16", "17", "18", "19", "21", "22", "24", "27",
        "28", "31", "32", "33", "34", "35", "37", "38", "41", "42", "43", "44", "45", "46", "47",
        "48", "49", "51", "53", "54", "55", "61", "62", "63", "64", "65", "66", "67", "68", "69",
        "71", "73", "74", "75", "77", "79", "81", "82", "83", "84", "85", "86", "87", "88", "89",
        "91", "92", "93", "94", "95", "96", "97", "98", "99" };
    Set<String> dddSet = new HashSet<>(Arrays.asList(DDDs));
    return dddSet.contains(telefone.substring(0, 2));
  }
}