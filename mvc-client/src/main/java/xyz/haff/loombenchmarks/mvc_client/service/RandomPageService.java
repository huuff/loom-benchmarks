package xyz.haff.loombenchmarks.mvc_client.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.client.api.BookEntityEntityControllerApi;
import org.openapitools.client.model.PagedModelEntityModelBookEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class RandomPageService {
    private final BookEntityEntityControllerApi apiClient;
    @Value("${PAGE_SIZE:100}")
    private Integer pageSize;
    private Integer lastPage = null;

    public PagedModelEntityModelBookEntity randomPage() throws Exception {
        if (lastPage == null) {
            var firstPage = apiClient.getCollectionResourceBookentityGet1(0, pageSize, List.of());
            this.lastPage = (int) (firstPage.getPage().getTotalPages() - 1);
        }

        var randomPage = ThreadLocalRandom.current().nextInt(lastPage);
        return apiClient.getCollectionResourceBookentityGet1(randomPage, pageSize, List.of());
    }
}
