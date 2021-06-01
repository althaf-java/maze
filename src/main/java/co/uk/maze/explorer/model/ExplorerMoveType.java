package co.uk.maze.explorer.model;

import java.util.Arrays;

public enum ExplorerMoveType {
    LEFT('L'),
    RIGHT('R'),
    FORWARD('F');

    private Character code;

    ExplorerMoveType(Character code){
        this.code = code;
    }

    public Character getCode() {
        return code;
    }

    public static ExplorerMoveType getExplorerMoveType(Character code) {
        return Arrays.stream(ExplorerMoveType.values()).filter(
                (codeParam) -> codeParam.getCode().toString().equalsIgnoreCase(code.toString()))
                .findFirst().get();
    }
}
