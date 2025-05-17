package ru.cherkasov.bencode.element;

import lombok.Builder;
import lombok.Getter;
import ru.cherkasov.ElementType;

import java.util.Objects;

@Getter
@Builder()
public abstract class AbstractBenCodeElement<T> {
    private final T value;
    private final ElementType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractBenCodeElement<?> that = (AbstractBenCodeElement<?>) o;
        return value.equals(that.value) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
