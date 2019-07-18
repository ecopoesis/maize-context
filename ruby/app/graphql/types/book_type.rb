require 'repo'

module Types
  class BookType < Types::BaseObject
    field :id, ID, null: false
    field :name, String, null: true
    field :page_count, Integer, null: false
    field :author, AuthorType, null: true

    def author
      ::Repo.authors.find { |a| a[:id] == object[:author_id] }
    end
  end
end
