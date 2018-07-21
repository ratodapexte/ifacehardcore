import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Iface
{

    public static void deleteOnMatrix(int[][] matrix, int index) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == index)
                    matrix[i][j] = 0;
            }
    }

    public static void deleteOnMatrix(String[][] matrix, String string) {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j].equals(string))
                    matrix[i][j] = null;
            }
        }
    }

    public static void deleteMessages(String[][][] matrix, int[] friendList, int index)
    {
        for (int i = 0; i < friendList.length; i++)
        {
            if(friendList[i] != 0)
            {
                for (int j = 0; j < matrix[i].length; j++)
                {
                    matrix[index][friendList[i]][j] = null;
                    matrix[friendList[i]][index][j] = null;
                }
            }
        }
    }

    public static boolean isThereName(String[] name, String verify)
    {
        for (String string : name)
        {
            if(verify.equals(string))
                return true;
        }
        return false;
    }

    public static boolean isThereLogin(String[] login, String verify)
    {
        for (String string : login)
        {
            if(verify.equals(string))
                return true;
        }
        return false;
    }

    public static boolean isUserAdded(int[] listOfFriends, int index)
    {
        for (int i : listOfFriends)
        {
            if(i == index)
                return true;
        }
        return false;
    }

    public static int getIndexByString(String[] aux, String verify)
    {
        for (int i = 0; i < aux.length; i++)
        {
            if(aux[i] != null)
            {
                if (aux[i].equals(verify))
                {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void addStringOnString(String[] string, String element)
    {
        for (int i = 0; i < string.length; i++)
        {
            if (string[i] == null)
            {
                string[i] = element;
                break;
            }
        }
    }

    public static void addIntOnMatrix(int[][] matrix, int lineIndex, int element)
    {
        for (int i = 0; i < matrix[lineIndex].length; i++)
        {
            if(matrix[lineIndex][i] == 0)
            {
                matrix[lineIndex][i] = element;
                break;
            }
        }
    }

    public static void resetIntMatrixLine(int[][] matrix, int line)
    {
        for (int i = 0; i < matrix[line].length; i++)
        {
            matrix[line][i] = 0;
        }
    }

    public static void deleteIntOnMatrix(int[][] matrix, int lineIndex, int columnIndex)
    {
        matrix[lineIndex][columnIndex] = 0;
    }

    public static void addStringOnMatrix(String[][] matrix, int lineIndex, String element)
    {
        for (int i = 0; i < matrix[lineIndex].length; i++)
        {
            if(matrix[lineIndex][i] == null)
            {
                matrix[lineIndex][i] = element;
                break;
            }
        }
    }

    public static void resetStringMatrixLine(String[][] string, int line)
    {
        for (int i = 0; i < string[line].length; i++)
        {
            string[line][i] = null;
        }
    }

    public static void deleteStringOnMatrix(String[][] matrix, int lineIndex, int columnIndex)
    {
        matrix[lineIndex][columnIndex] = null;
    }

    public static boolean isUserMemberOf(int[][] matrix, String name[], String[] description, int index)
    {
        boolean result = false;
        System.out.println("***** Comunidades *****");
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == index)
                {
                    System.out.println(i + " - " + name[i] + " : " + description[i]);
                    result = true;
                }
            }
        }

        return result;
    }

    public static String writeMessage(String name)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Escreva a mensagem: ");
        String message = scanner.nextLine();

        Calendar calendar = Calendar.getInstance();
        // calendar.setTime(date);

        System.out.println(formato.format(calendar.getTime()));

        message =  name + " [" + formato.format(calendar.getTime()) + "]: " + message;

        return message;
    }

    public static int sigIn(String[] login, String[] password)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****Menu de login*****");
        System.out.print("Login: ");
        String loginLog = scanner.nextLine();
        int index = getIndexByString(login, loginLog);

        if (index != -1) {
            System.out.print("Password: ");
            String passwordLog = scanner.nextLine();
            if (passwordLog.equals(password[index])) {
                return index;
            }
        }
        return -1;
    }

    public static void showAttributes(String[] attribute, String[] attributeDescription)
    {
        for (int i = 0; i < attribute.length; i++)
        {
            if(attribute[i] != null)
            {
                System.out.println(i + " - "+ attribute[i] + ": " + attributeDescription[i]);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String[] name = new String[100], login = new String[100], password = new String[100];
        String[][] attribute = new String[100][100], attributeDescription = new String[100][100];
        String[][][] messages = new String[100][100][100];

        String[] comunityName = new String[100], communityAdm = new String[100], communityDescription = new String[100];
        int[][] communityMembers = new int[100][100], communityPendingMembers = new int[100][100];
        String[][] communityMessages = new String[100][100];

        int[][]  friendDictionary = new int[100][100], pendentFriends = new int[100][100];

        name[0] = "adm";
        login[0] = "adm";
        password[0] = "adm";
        name[1] = "a";
        login[1] = "a";
        password[1] = "a";
        name[2] = "b";
        login[2] = "b";
        password[2] = "b";


        //	System.out.println("********************    " + attributeCounter[10] + " *********************");
        while(true)
        {
            for (int i = 0; i < 10; ++i) System.out.println();
            System.out.println("*****IFACE*****");
            System.out.printf("1 - Entrar%n2 - cadastrar%nOpcao: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                    int index = sigIn(login, password);
                    while(index != -1)
                    {
                        System.out.println("*****Bem vindo " + name[index] + "*****");
                        System.out.printf("Menu:%n1 - perfil%n2 - Amigos%n3 - Comunidade%n4 - Deletar conta%nOpcao: ");

                        int choiceLog = scanner.nextInt();
                        scanner.nextLine();

                        switch(choiceLog)
                        {
                            case 1:
                                System.out.println("*****Menu de Perfil*****");

                                System.out.printf("%n*****Perfil*****%n");
                                showAttributes(attribute[index], attributeDescription[index]);
                                System.out.printf("Fim do perfil%n");

                                System.out.printf("1 - Adicionar atributo%n2 - Excluir atributo%n3 - Alterar atributo%n" +
                                        "Opcao: ");

                                int choiceProf = scanner.nextInt();
                                scanner.nextLine();

                                switch(choiceProf)
                                {
                                    case 1:

                                        System.out.println("Adicionando");
                                        System.out.print("Digite o nome do atributo: ");
                                        String addedAttribute = scanner.nextLine();

                                        System.out.print("Digite a descricao do atributo: ");
                                        String addedDescription = scanner.nextLine();

                                        addStringOnMatrix(attribute, index, addedAttribute);
                                        addStringOnMatrix(attributeDescription, index, addedDescription);
                                        System.out.println("Atributo adicionado.");
                                        break;
                                    case 2:
                                        System.out.println("Excluindo");
                                        System.out.print("Digite o indice do atributo a ser excluido: ");
                                        int indexToDelete = scanner.nextInt();
                                        scanner.nextLine();

                                        deleteStringOnMatrix(attribute, index, indexToDelete);
                                        deleteStringOnMatrix(attributeDescription, index, indexToDelete);
                                        System.out.println("Atributo deletado!");
                                        break;
                                    case 3:
                                        System.out.println("Alterando");
                                        System.out.print("Digite o indice do atributo a ser alterado: ");
                                        int indexToChange = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.print("Digite a nova descricao: ");
                                        String newDescription = scanner.nextLine();
                                        attributeDescription[index][indexToChange] = newDescription;

                                        System.out.printf("%nAtributo alterado%n");
                                        break;
                                }

                                break;
                            case 2:
                                for (int i = 0; i < 10; ++i) System.out.println();
                                System.out.println("*****Menu de amizade*****");
                                System.out.printf("1 - Adicionar amigo%n2 - Solicitacao pendente%n3 - Lista de amigos%n"
                                        + "4 - enviar mensagem%n5 - Ver mensagens%nOpcao: ");
                                int choiceFriend = scanner.nextInt();
                                scanner.nextLine();
                                int friendIndex, messageIndex;
                                switch(choiceFriend)
                                {
                                    case 1:
                                        System.out.println("Adiconando amigo");
                                        System.out.print("Digite o nome do amigo: ");
                                        String friendName = scanner.nextLine();
                                        friendIndex = getIndexByString(name, friendName);

                                        if(friendIndex == index)
                                            System.out.println("Voce nao pode se adicionar!");
                                        else if(friendIndex == -1)
                                            System.out.println("Ususario nao encontrado!");
                                        else if(isUserAdded(friendDictionary[index], friendIndex))
                                            System.out.println("Usuario ja adicionado!");
                                        else
                                            addIntOnMatrix(pendentFriends, friendIndex, index);
                                        break;
                                    case 2:
                                        System.out.println("Aceitar solicitacoes");
                                        System.out.println("Lista de solicitacoes");

                                        for (int i = 0; i < pendentFriends[index].length; i++)
                                        {
                                            if(pendentFriends[index][i] != 0)
                                            {
                                                System.out.println(i + " - " + name[pendentFriends[index][i]]);
                                            }
                                        }

                                        System.out.print("Selecione o indice a adicionar: ");
                                        friendIndex = scanner.nextInt();

                                        addIntOnMatrix(friendDictionary, index, pendentFriends[index][friendIndex]);
                                        addIntOnMatrix(friendDictionary, pendentFriends[index][friendIndex], index);
                                        pendentFriends[index][friendIndex] = 0;

                                        System.out.println("Usuario adicionado");
                                        break;
                                    case 3:
                                        System.out.println("***** Lista de amigos *****");
                                        for (int i = 0; i < friendDictionary[index].length; i++)
                                        {
                                            if(friendDictionary[index][i] != 0 )
                                                System.out.println(i + " - " + name[friendDictionary[index][i]]);
                                        }
                                        System.out.println("***** Fim da lista *****");
                                        break;
                                    case 4:
                                        for (int i = 0; i < 10; ++i) System.out.println();
                                        System.out.println("***** Envio de mensagens *****");
                                        System.out.println("***** Lista de amigos *****");
                                        for (int i = 0; i < friendDictionary[index].length; i++)
                                        {
                                            if(friendDictionary[index][i] != 0 )
                                                System.out.println(i + " - " + name[friendDictionary[index][i]]);
                                        }
                                        System.out.println("***** Fim da lista *****");

                                        System.out.println("Escolha o índice do amigo: ");
                                        messageIndex = scanner.nextInt();
                                        scanner.nextLine();

                                        if(friendDictionary[index][messageIndex] != 0)
                                        {
                                            String message = writeMessage(name[index]);

                                            addStringOnMatrix(messages[friendDictionary[index][messageIndex]], index, message);
                                            addStringOnMatrix(messages[index], friendDictionary[index][messageIndex], message);
                                        }
                                        else
                                            System.out.println("Amigo não encontrado!");

                                        break;
                                    case 5:
                                        for (int i = 0; i < 10; ++i) System.out.println();
                                        System.out.println("***** Vizualizar mensagens *****");
                                        System.out.println("***** Lista de amigos *****");
                                        for (int i = 0; i < friendDictionary[index].length; i++)
                                        {
                                            if(friendDictionary[index][i] != 0 )
                                                System.out.println(i + " - " + name[friendDictionary[index][i]]);
                                        }
                                        System.out.println("***** Fim da lista *****");

                                        System.out.println("Escolha o índice do amigo: ");
                                        messageIndex = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.println("***** Lista de mensagens *****");
                                        if(friendDictionary[index][messageIndex] != 0)
                                        {
                                            System.out.println("Mensagem para " + name[friendDictionary[index][messageIndex]]);
                                                    for (int i = 0; i < messages[index][friendDictionary[index][messageIndex]].length; i++)
                                                    {
                                                        if( messages[index][friendDictionary[index][messageIndex]][i] != null)
                                                            System.out.println( messages[index][friendDictionary[index][messageIndex]][i]);
                                                    }
                                        }
                                                else
                                                    System.out.println("Amigo não encontrado!");
                                                break;
                                        }
                                        break;
                                    case 3:
                                        System.out.println("***** Comunidades *****");
                                        int comuChoice;
                                        String commuName;

                                        System.out.printf("1 - Participar de comunidade%n2 - Gerenciar ou criar%n" +
                                                "3 - Mandar mensagem%n4 - Ver mensagens%nOpcao: ");
                                        comuChoice = scanner.nextInt();
                                        scanner.nextLine();

                                        switch(comuChoice)
                                        {
                                            case 1:
                                                System.out.print("Digite o nome da comunidade: ");
                                                commuName = scanner.nextLine();
                                                int commuIndex = getIndexByString(comunityName, commuName);
                                                if(commuIndex != -1)
                                                {
                                                    addIntOnMatrix(communityPendingMembers, commuIndex, index);
                                                    System.out.println("Pedido enviado");
                                                }
                                                else
                                                    System.out.println("Comunidade nao encontrada!");
                                                break;
                                            case 2:
                                                if(isThereName(communityAdm, name[index]))
                                                {
                                                    System.out.println("***** Gerenciamento de comunidade *****");
                                                    int communintyIndex = getIndexByString(communityAdm, name[index]);
                                                    System.out.println("1 - Ver membros%n2 - Membros pendentes%n3 - Excluir membros%nOpcao: ");
                                                    comuChoice = scanner.nextInt();
                                                    scanner.nextLine();

                                                    switch(comuChoice)
                                                    {
                                                        case 1:
                                                            System.out.println("***** Lista de membros *****");

                                                            for (int i = 0; i < communityMembers[communintyIndex].length; i++)
                                                            {
                                                                if(communityMembers[communintyIndex][i] != 0)
                                                                    System.out.println(i + " - " + name[communityMembers[communintyIndex][i]]);
                                                            }

                                                            System.out.println("***** Fim da lista *****");
                                                            break;
                                                        case 2:
                                                            System.out.println("***** Lista de membros pendentes *****");

                                                            for (int i = 0; i < communityPendingMembers[communintyIndex].length; i++)
                                                            {
                                                                if(communityPendingMembers[communintyIndex][i] != 0)
                                                                    System.out.println(i + " - " + name[communityPendingMembers[communintyIndex][i]]);
                                                            }
                                                            System.out.println("***** Fim da lista *****");

                                                            System.out.print("Digite o indice a ser adicionado: ");
                                                            int indexComu = scanner.nextInt();

                                                            if(communityPendingMembers[communintyIndex][indexComu] != 0)
                                                            {
                                                                addIntOnMatrix(communityMembers, communintyIndex, communityPendingMembers[communintyIndex][indexComu]);
                                                                System.out.println("Membro adicionado!");
                                                            }
                                                            else
                                                                System.out.println("Indice incorreto!");
                                                            break;
                                                        case 3:
                                                            System.out.println("***** Lista de membros *****");

                                                            for (int i = 0; i < communityMembers[communintyIndex].length; i++)
                                                            {
                                                                if(communityMembers[communintyIndex][i] != 0)
                                                                    System.out.println(i + " - " + name[communityMembers[communintyIndex][i]]);
                                                            }
                                                            System.out.println("***** Fim da lista *****");

                                                            System.out.print("Digite o indice a ser deletado: ");
                                                            int indexDel = scanner.nextInt();

                                                            if(communityMembers[communintyIndex][indexDel] != 0)
                                                            {
                                                                deleteIntOnMatrix(communityMembers, communintyIndex, indexDel);
                                                                System.out.println("Membro deletado!");
                                                            }
                                                            else
                                                                System.out.println("Indice incorreto!");
                                                            break;
                                                    }
                                                }
                                                else
                                                {
                                                    System.out.println("***** Criar comunidade *****");
                                                    System.out.print("Digite o nome da comunidade: ");
                                                    commuName = scanner.nextLine();
                                                    while(getIndexByString(comunityName, commuName) != -1)
                                                    {
                                                        System.out.println("Nome ja cadastrado!");
                                                        System.out.print("Digite o nome da comunidade: ");
                                                        commuName = scanner.nextLine();
                                                    }

                                                    System.out.println("Descricao da comunidade");
                                                    String communityDscpt = scanner.nextLine();

                                                    addStringOnString(communityDescription, communityDscpt);
                                                    addStringOnString(comunityName, commuName);
                                                    addStringOnString(communityAdm, name[index]);

                                                    System.out.println("Comunidade cadastrada");
                                                }
                                                break;
                                            case 3:
                                                if(isUserMemberOf(communityMembers, comunityName, communityDescription, index))
                                                {
                                                    System.out.println("Indice da comunidade");
                                                    comuChoice = scanner.nextInt();
                                                    scanner.nextLine();

                                                    if (comunityName[comuChoice] != null)
                                                    {
                                                        if(isUserAdded(communityMembers[comuChoice], index))
                                                        {
                                                            String commuMessage = writeMessage(name[index]);

                                                            addStringOnMatrix(communityMessages, comuChoice, commuMessage);
                                                        }
                                                        else
                                                            System.out.println("Você não pertence a comunidade");
                                                    }
                                                    else
                                                        System.out.println("Comunidade inexistente!");
                                                }
                                                break;
                                            case 4:
                                                System.out.println("***** Ver mensagens de comunidade *****");
                                                if(isUserMemberOf(communityMembers, comunityName, communityDescription, index))
                                                {
                                                    System.out.println("Indice da comunidade");
                                                    comuChoice = scanner.nextInt();
                                                    scanner.nextLine();

                                                    if (comunityName[comuChoice] != null)
                                                    {
                                                        if(isUserAdded(communityMembers[comuChoice], index))
                                                        {
                                                            for (int i = 0; i < communityMessages[comuChoice].length; i++)
                                                            {
                                                                if (communityMessages[comuChoice][i] != null)
                                                                    System.out.println(communityMessages[comuChoice][i]);
                                                            }
                                                        }
                                                        else
                                                            System.out.println("Você não pertence a comunidade");
                                                    }
                                                    else
                                                        System.out.println("Comunidade inexistente!");

                                                }
                                                break;
                                        }

                                        break;
                                    case 4:
                                        name[index] = null;
                                        password[index] = null;
                                        login[index] = null;
                                        deleteMessages(messages, friendDictionary[index], index);
                                        resetStringMatrixLine(attribute, index);
                                        resetStringMatrixLine(attributeDescription, index);
                                        deleteOnMatrix(friendDictionary, index);
                                        deleteOnMatrix(pendentFriends, index);
                                        deleteOnMatrix(communityMembers, index);
                                        deleteOnMatrix(communityPendingMembers, index);
                                        choiceLog = 99;

                                        break;
                                }
                                if(choiceLog == 99)
                                    break;
                    }
                    break;
                case 2:
                    for (int i = 0; i < 50; ++i) System.out.println();
                    System.out.println("*****Menu de Cadastro*****");
                    System.out.print("Nome: ");
                    String nameCad = scanner.nextLine();

                    while(isThereName(name, nameCad))
                    {
                        System.out.println("Nome ja cadastrado!!!");
                        System.out.print("Nome: ");
                        nameCad = scanner.nextLine();
                    }

                    System.out.print("Login: ");
                    String loginCad = scanner.nextLine();

                    while(isThereLogin(login, loginCad))
                    {
                        System.out.println("Login ja cadastrado!!!");
                        System.out.print("Nome: ");
                        loginCad = scanner.nextLine();
                    }

                    System.out.print("Senha: ");
                    String passwordCad = scanner.nextLine();

                    addStringOnString(name, nameCad);
                    addStringOnString(login, loginCad);
                    addStringOnString(password, passwordCad);

                    System.out.println("Conta cadastrada com sucesso!");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }

    }
}