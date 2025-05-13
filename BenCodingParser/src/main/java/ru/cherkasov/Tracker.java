package ru.cherkasov;

public record Tracker(
        String announceUrl,
        Info info
) {
    public record Info(
        int pieceLength,
        String pieces,
        int length,
        String name
    ){}
}
