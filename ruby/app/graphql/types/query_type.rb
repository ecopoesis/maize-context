require 'repo'

module Types
  class QueryType < Types::BaseObject
    # Add root-level fields here.
    # They will be entry points for queries on your schema.

    field :book, BookType, null: true do
      argument :id, ID, required: true
    end

    def book(id:)
      ::Repo::books.find { |b| b[:id] == id }
    end
  end
end
