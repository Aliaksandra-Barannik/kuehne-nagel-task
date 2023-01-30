package dto.requests;

import dto.IsbnDto;
import java.util.List;
import java.util.Objects;

public class AddBooksRequest {

    private String userId;
    private List<IsbnDto> collectionOfIsbns;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<IsbnDto> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<IsbnDto> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AddBooksRequest that = (AddBooksRequest) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(collectionOfIsbns, that.collectionOfIsbns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, collectionOfIsbns);
    }

    @Override
    public String toString() {
        return "AddBooksRequest{" +
                "userId='" + userId + '\'' +
                ", collectionOfIsbns=" + collectionOfIsbns +
                '}';
    }

    public static class Builder {

        private AddBooksRequest request = new AddBooksRequest();

        public Builder withUserId(String userId) {
            request.userId = userId;
            return this;
        }

        public Builder withCollectionOfIsbns(List<IsbnDto> collectionOfIsbns) {
            request.collectionOfIsbns = collectionOfIsbns;
            return this;
        }

        public AddBooksRequest build() {
            return request;
        }
    }
}
